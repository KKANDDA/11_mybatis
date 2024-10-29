package com.ohgiraffers.section03.remix.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section03.remix.service.MenuService;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintResult printResult;
    private final MenuService menuService;

    public MenuController() {

        printResult = new PrintResult();
        menuService = new MenuService();
    }

    public void selectAllMenu() {

        List<MenuDTO> menuDTOList = menuService.selectAllMenu();

        if(menuDTOList != null) {
            printResult.printMenuList(menuDTOList);
        }else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByCode(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        MenuDTO menuDTO = menuService.selectMenuByCode(code);
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

        boolean result = menuService.registMenu(menuDTO);

        if(result) {
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

        boolean result = menuService.updateMenu(menuDTO);
        if(result) {
            printResult.printSuccessMessage("update");
        }else{
            printResult.printErrorMessage("update");
        }

    }

    public void deleteMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        boolean result = menuService.deleteMenu(code);
        if(result) {
            printResult.printSuccessMessage("delete");
        }else {
            printResult.printErrorMessage("delete");
        }
    }
}
