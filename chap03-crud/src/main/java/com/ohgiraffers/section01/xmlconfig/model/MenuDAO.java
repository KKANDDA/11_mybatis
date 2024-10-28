package com.ohgiraffers.section01.xmlconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class MenuDAO {

    // 쿼리문을 수행할 놈~!~@#@#~@
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.selectAllMenu");

    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {
        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int modifyMenu(SqlSession sqlSession, MenuDTO menuDTO) {
        return sqlSession.update("MenuMapper.modifyMenu", menuDTO);
    }

    public int deleteMenu(SqlSession sqlSession, MenuDTO menuDTO) {
        return sqlSession.delete("MenuMapper.deleteMenu", menuDTO);
    }
}
