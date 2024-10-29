package com.ohgiraffers.section03.remix.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section03.remix.model.MenuMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getRemixSession;

public class MenuService {

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getRemixSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuDTOList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuDTOList;
    }


    public MenuDTO selectMenuByCode(int code){
        SqlSession sqlSession = getRemixSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menuDTO = menuMapper.selectMenuByCode(code);
        sqlSession.close();
        return menuDTO;
    }

    public boolean registMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getRemixSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menuDTO);
        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();
        return result>0;
    }

    public boolean updateMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getRemixSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.modifyMenu(menuDTO);
        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0;
    }

    public boolean deleteMenu(int code) {
        SqlSession sqlSession = getRemixSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        boolean result = menuMapper.deleteMenu(code);
        if(result){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}
