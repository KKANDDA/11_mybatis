package com.ohgiraffers.section02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Application {
    public static void main(String[] args) {

        // mybatis 는 기본적으로 resources 폴더를 기준으로 XML 파일을 찾을 수 있다.
        String resource = "mybatis-config.xml";

        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource); // 정보를 읽어서 사용하기 위한 객체.
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // 빌드 메소드르 쓰기 위함..

            session = sqlSessionFactory.openSession(false);

            Date date = session.selectOne("mapper.selectSysDate"); // 쿼리문의 결과가 하나면 One 둘 이상이면 List
            System.out.println("date = " + date);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
    }
}
