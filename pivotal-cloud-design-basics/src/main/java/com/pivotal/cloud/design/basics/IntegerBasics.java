package com.pivotal.cloud.design.basics;

/**
 * @className: com.pivotal.cloud.design.basics.IntegerBasics
 * @title: IntegerBasics
 * @description: 封装Pivotal项目IntegerBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-06 01:18
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class IntegerBasics {
    public static void main(String[] args) {
        // 对于对象引用类型：==比较的是对象的内存地址。
        // 对于基本数据类型：==比较的是值。
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        //[1].false->==比较的是对象的内存地址
        System.out.println(a == b);
        //[2].true->equals比较的是值
        System.out.println(a.equals(b));
        //[3].true->a自动拆箱成int类型再和c比较
        System.out.println(a == c);
        //[3].true->b自动拆箱成int类型再和c比较
        System.out.println(b == c);
        //[4].如果整型字面量的值在-128到127之间，那么自动装箱时不会new新的Integer对象，而是直接引用常量池中的Integer对象，超过范围 a1==b1的结果是false
        Integer a1 = 128;
        Integer b1 = 128;
        System.out.println(a1 == b1); // false
        Integer a2 = 127;
        Integer b2 = 127;
        System.out.println(a2 == b2); // true
    }
}
