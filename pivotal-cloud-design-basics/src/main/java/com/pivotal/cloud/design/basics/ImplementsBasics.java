package com.pivotal.cloud.design.basics;

/**
 * @className: com.pivotal.cloud.design.basics.ImplementsBasics
 * @title: ImplementsBasics
 * @description: 封装Pivotal项目ImplementsBasics类
 * @content: //测试实现Implements问题
 * @author: marklin
 * @datetime: 2020-07-06 03:19
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class ImplementsBasics extends ExtendsBasics {
    public ImplementsBasics() {
        System.out.println("implements");
    }

    public static void main(String[] args) {
        //在继承关系下，创建子类对象，先执行父类的构造方法，再执行子类的构造方法。
        ImplementsBasics basics = new ImplementsBasics();
    }
}
