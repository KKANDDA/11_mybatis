package com.ohgiraffers.section03.remix;

import com.ohgiraffers.section03.remix.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        MenuController mc = new MenuController();

        do{
            System.out.println("------- 메뉴 관리 --------");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("번호를 입력해라~!@~@~!$ㄸ#@!%ㄲ$!@##$@~!!~");
            int no = scr.nextInt();

            switch (no){
                case 1: mc.selectAllMenu(); break;
                case 2: mc.selectMenuByCode(inputMenuCode()); break;
                case 3: mc.registMenu(inputMenu()); break;
                case 4: mc.modifyMenu(inputModifyMenu()); break;
                case 5: mc.deleteMenu(inputMenuCode()); break;
                default:
                    System.out.println("잘 못 된 메뉴 선택~!@#@!$@!#$#@!$#@!$@~~"); break;
            }
        }while (true);
    }

    private static Map<String, String> inputMenuCode(){
        Scanner scr = new Scanner(System.in);
        System.out.println("조회하고픈 메뉴의 코드를 입력해라~!~!~!!!!!!! 코드는 네가 재주껏 알아 내거라~!@~#!@%$ㄲ@!#@!~@~!!~~!");
        String code = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("code",code);
        return parameter;
    }

    private static Map<String, String> inputMenu() {
        Scanner scr = new Scanner(System.in);
        System.out.println("추가하고픈 메뉴의 이름을 적으세요~!@!@#!#~!");
        String name = scr.nextLine();
        System.out.println("메뉴의 가격ㅂㅉㄸㄲㅉㄸ`!@@#!~@~~!~~!!");
        String price = scr.nextLine();
        System.out.println("메뉴의 카테고리 분류 코드~!@~@!~!~@~!~!~");
        String categoryCode = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("name",name);
        parameter.put("price",price);
        parameter.put("categoryCode",categoryCode);
        return parameter;
    }

    private static Map<String, String> inputModifyMenu(){
        Scanner scr = new Scanner(System.in);
        System.out.println("수정할 메뉴 코드를 입력해 주세요 : ");
        String code = scr.nextLine();
        System.out.println("수정할 메뉴의 이름을 입력해 주세요 : ");
        String name = scr.nextLine();
        System.out.println("수정할 메뉴의 가격을 입력해 주세요 : ");
        String price = scr.nextLine();
        System.out.println("수정할 메뉴의 카테고리 코드를 입력해 주세요 : ");
        String categoryCode = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("code",code);
        parameter.put("name",name);
        parameter.put("price",price);
        parameter.put("categoryCode",categoryCode);

        return parameter;
    }
}
