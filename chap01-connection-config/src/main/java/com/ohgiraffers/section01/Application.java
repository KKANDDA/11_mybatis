package com.ohgiraffers.section01;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.Date;

public class Application {

    // db 정보 필드 작성
    private static  String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static String URL = "jdbc:mysql://localhost:3306/menudb";

    private static String USER = "gangnam";

    private static String PASS = "gangnam";


    public static void main(String[] args) {

        /*
        * JdbcTransactionFactory: 수동 커밋
        * ManagedTransactionFactory: 오토 커밋
        *
        * ---
        *
        * PolledDateSource: ConnectionPool을 사용함. // 미리 커넥션 객체를 여러 개 생성해 나눠주는 방식..
        * UnPoolDateSource: 사용하지 않음.
        * */

        // 환경 정보 저장 (객체 아이디, 트랜잭션 종류, 풀 사용 여부)
        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER, URL, USER, PASS)
        );

        // 생성한 환경 설정 정보로 MyBatis 설정 객체 생성 - ibatis를 임포트..
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class); // 맵퍼 등록

        /*
        * sqlSessionFactory : sqpSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        * sqlSessionFactoryBuilder: sqlSessionFactory 타입의 객체를 생성하기 위한 빌드 역할
        * build(): 설정에 대한 정보를 담고 있는 configuration 타입의 객체 혹은
        *          외부 설정 파일과 연관된 데이터를 매개변수로 전달하면 sqlSessionFactory 타입의 객체를 반환하는 메소드
        *
        * sqlSession: jdbc의 connection 같은 객체
        * */

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration); // 커넥션 객체 공장
        System.out.println("sqlSessionFactory = " + sqlSessionFactory);

        SqlSession session = sqlSessionFactory.openSession(false); // false는 오토커밋을 껐다는 뜻..

        Mapper mapper = session.getMapper(Mapper.class); // 여러개를 꺼낼 수도 있으니..
        Date date = mapper.selectSysDate(); // 메소드로 쿼리문으 호출
        System.out.println(date);
        session.close();

    }
}
