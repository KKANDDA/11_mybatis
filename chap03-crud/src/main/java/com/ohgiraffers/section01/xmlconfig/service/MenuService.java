package com.ohgiraffers.section01.xmlconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;


public class MenuService {

    private  final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    // DB와 연결만 해 줄 놈 !~!@~!~#~$%!##!~@~!!
    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        List<MenuDTO> menuDTOList = menuDAO.selectAllMenu(sqlSession);
        sqlSession.close();
        return menuDTOList;

    }


    public MenuDTO selectMenuByCode(Map<String, String> stringStringMap) {
        int code = Integer.parseInt(stringStringMap.get("code"));
        SqlSession sqlSession = getSqlSession();
        MenuDTO menuDTO = menuDAO.selectMenuByCode(sqlSession, code);
        sqlSession.close();
        return menuDTO;
    }

    public boolean registMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.insertMenu(sqlSession, menuDTO);

        if (result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }

    public boolean modifyMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.modifyMenu(sqlSession, menuDTO);
        if (result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }

    public boolean deleteMenuByCode(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.deleteMenu(sqlSession, menuDTO);
        if (result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;
    }
}
