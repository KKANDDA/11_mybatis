package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.service.MenuService;

import java.util.List;
import java.util.Map;

public class MenuController {
    // view 대신 사용할 객체
    private final PrintResult printResult;

    //컨트롤러의 명령을 받을 객체
    private final MenuService menuService;

    // 컨트롤러가 생성될 때 한번에 다 생성!
    public MenuController() { // 호출됐을 때 바로 사용할 수 있도록..
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    // mapping 대체...
    public void selectAllMenu() {

        List<MenuDTO> menuDTOList = menuService.selectAllMenu();

        if(menuDTOList != null) {
            printResult.printMenuList(menuDTOList);
        }else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByCode(Map<String, String> stringStringMap) {
        MenuDTO menuDTO = menuService.selectMenuByCode(stringStringMap);
        if(menuDTO != null) {
            printResult.printMenuByCode(menuDTO);
        }else {
            printResult.printErrorMessage("selectMenuByCode");
        }
    }

    public void registMenu(Map<String, String> parameter) {

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setName(name);
        menuDTO.setPrice(price);
        menuDTO.setCategoryCode(categoryCode);

        if(menuService.registMenu(menuDTO)){
            printResult.printSuccessMessage("insert");
        }else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setCode(code);
        menuDTO.setName(name);
        menuDTO.setPrice(price);
        menuDTO.setCategoryCode(categoryCode);

        if(menuService.modifyMenu(menuDTO)){
            printResult.printSuccessMessage("update");
        }else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setCode(code);

        if(menuService.deleteMenuByCode(menuDTO)){
            printResult.printSuccessMessage("delete");
        }else {
            printResult.printErrorMessage("delete");
        }
    }
}
