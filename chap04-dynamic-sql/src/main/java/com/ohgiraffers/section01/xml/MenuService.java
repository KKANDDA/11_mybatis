package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSession;

public class MenuService {

    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price) {
        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        // 그냥 값으로는 비교할 수 없다. 키값으로 이름을 주거나, DTO에 담아야 비교가 가능하다. mybatis가 제한하고 있다.
        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);
        List<MenuDTO> menuDTOList = mapper.selectMenuByPrice(map);

        if (menuDTOList != null && menuDTOList.size() > 0) {
            for (MenuDTO menuDTO : menuDTOList) {
                System.out.println(menuDTO);
            }
        }else{
            System.out.println("검색 결과가 없습니다.");
        }
        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuDTOList = mapper.searchMenu(searchCriteria);

        if (menuDTOList != null && menuDTOList.size() > 0) {
            for (MenuDTO menuDTO : menuDTOList) {
                System.out.println(menuDTO);
            }
        }else{
            System.out.println("검색 결과가 없습니다. ");
        }
        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<MenuDTO> menuDTOList = mapper.searchMenuBySupCategory(searchCriteria);

        if (menuDTOList != null && menuDTOList.size() > 0) {
            for (MenuDTO menuDTO : menuDTOList) {
                System.out.println(menuDTO);
            }
        }else{
            System.out.println("검색 결과가 없습니다.");
        }
        sqlSession.close();
    }

    public void searMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> codeList = new HashMap<>();
        codeList.put("randomMenuCodeList", randomMenuCodeList);

        List<MenuDTO> menuDTOList = mapper.searchMenuByRandomMenuCode(codeList);

        if(menuDTOList != null && menuDTOList.size() > 0) {
            for (MenuDTO menuDTO : menuDTOList) {
                System.out.println(menuDTO);
                System.out.println(randomMenuCodeList);
            }
        }else {
            System.out.println("검색결과가 없습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuDTOList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuDTOList != null && menuDTOList.size() > 0) {
            for (MenuDTO menuDTO : menuDTOList) {
                System.out.println(menuDTO);
            }
        }else {
            System.out.println("검색결과가 없습니다..");
        }
    }
}
