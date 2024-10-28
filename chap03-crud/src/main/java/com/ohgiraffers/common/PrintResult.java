package com.ohgiraffers.common;

import com.ohgiraffers.dto.MenuDTO;

import java.util.List;

// 결과값을 출력해 줄 클래스 - html 대체
public class PrintResult {

    public void printMenuList(List<MenuDTO> menuDTOList) {
        for (MenuDTO menuDTO : menuDTOList) {
            System.out.println(menuDTO);
        }
    }

    public void printMenuByCode(MenuDTO menuDTO) {
        System.out.println(menuDTO);
    }

    public void printSuccessMessage(String code) {
        String message = null;
        switch (code) {
            case "insert" : message = "메뉴 등록에 성공하셨습니다!~!@~@@!!~"; break;
            case "update" : message = "메뉴 수정에 성공하셨습니다!~!@~@@!!~"; break;
            case "delete" : message = "메뉴 삭제에 성공하셨습니다!~!@~@@!!~"; break;

        }
        System.out.println("message = " + message);
    }

    public void printErrorMessage(String code) {
        String message = null;
        switch (code) {
            case "selectList" : message = "메뉴 전체 조회 실패"; break;
            case "selectMenuByCode" : message = "해당 코드의 메뉴 조회 실패"; break;
            case "insert" : message = "메뉴 등록에 실패하셨습니다.. ㅠㅠ"; break;
            case "update" : message = "메뉴 수정에 실패하셨습니다.. ㅠㅠ"; break;
            case "delete" : message = "메뉴 삭제에 실패하셨습니다.. ㅠㅠ"; break;

            default:message = "잘 못 된 처리"; break;
        }
        System.out.println("message = " + message);
    }



}
