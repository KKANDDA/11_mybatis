package com.ohgiraffers.section02.javaconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section02.javaconfig.model.MenuMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getJavaSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuDTOList = menuMapper.selectAllMenu();
        sqlSession.close();
        return menuDTOList;
    }

    public MenuDTO selectMenuByCode(Map<String, String> parameter) {
        SqlSession sqlSession = getJavaSqlSession();
        int code = Integer.parseInt(parameter.get("code"));
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menuDTO = menuMapper.selectMenuByCode(code);
        sqlSession.close();
        return menuDTO;

    }

    public boolean registMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getJavaSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menuDTO);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result>0? true : false;



    }

    public boolean updateMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getJavaSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menuDTO);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result>0? true : false;
    }

    public boolean deleteMenu(int code) {
        SqlSession sqlSession = getJavaSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(code);
        if(result > 0) {
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();
        return result>0? true : false;
    }
}
