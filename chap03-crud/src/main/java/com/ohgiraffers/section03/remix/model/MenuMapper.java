package com.ohgiraffers.section03.remix.model;

import com.ohgiraffers.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {
    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByCode(int code);

    int insertMenu(MenuDTO menuDTO);

    int modifyMenu(MenuDTO menuDTO);

    boolean deleteMenu(int code); // mybatis가 인트로 넘어온 값을 불린으로 형변환 해서 넘겨줄 수도 있다.
}
