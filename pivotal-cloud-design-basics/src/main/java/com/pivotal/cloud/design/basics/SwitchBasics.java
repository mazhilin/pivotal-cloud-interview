package com.pivotal.cloud.design.basics;

/**
 * @className: com.pivotal.cloud.design.basics.SwtichBasics
 * @title: SwtichBasics
 * @description: 封装Pivotal项目SwtichBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-02 15:38
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class SwitchBasics implements DesignBasics {

    public static int switchExp(int exps) {
        int result = 0;
        switch (exps) {
            case 1:
                result = 1;
                System.out.println(result);
                break; //可选
            case 2:
                //语句
                break; //可选
            case 3:
                result = 3;
                System.out.println(result);
                break; //可选
            case 4:
                result = 4;
                System.out.println(result);
                break; //可选
            default: //可选
                //语句
        }
        return result;
    }


    public void switchExps(int exps) {
        switch (exps) {
            case 1:
                System.out.println(1);
            case 2:
                //语句
            case 3:
                System.out.println(3);
            case 4:
                System.out.println(4);
        }
    }

    public static void main(String[] args) {
        // [1].测试switch问题
        //System.out.println(SwitchBasics.switchExp(2));
        switch (2) {
            case 1:
                System.out.println(1);
            case 2:
                //语句
            case 3:
                System.out.println(3);
            case 4:
                System.out.println(4);
        }


        int i = 9;
        switch (i) {
            default:
                System.out.println("default");
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
        }

        switch (i) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            default:
                System.out.println("default");
        }

        switch (i) {
            case 0:
                System.out.println("zero");
                break;
            default:
                System.out.println("default");
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
        }
    }
}
