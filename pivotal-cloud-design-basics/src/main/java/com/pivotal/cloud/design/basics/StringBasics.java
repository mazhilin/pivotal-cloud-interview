package com.pivotal.cloud.design.basics;

/**
 * @className: com.pivotal.cloud.design.basics.StringBasics
 * @title: StringBasics
 * @description: 封装Pivotal项目StringBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-03 22:19
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class StringBasics {
    public static void main(String[] args) {
        //比较== 和equals
        String x = "string";
        String y = "string";
        String z = new String("string");
        //true
        System.out.println(x == y);
        //false
        System.out.println(x == z);
        //true
        System.out.println(x.equals(y));
        //true
        System.out.println(x.equals(z));
    }
}
