package com.pivotal.cloud.design.basics;

/**
 * @className: com.pivotal.cloud.design.basics.MathBasics
 * @title: MathBasics
 * @description: 封装Pivotal项目MathBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-03 22:26
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class MathBasics {
  public static void main(String[] args) {
    //Math.round->函数返回一个数字四舍五入后最接近的整数
    //-1
    System.out.println(Math.round(-1.5));
    //-2
    System.out.println(Math.round(-1.5444444));
    //-2
    System.out.println(Math.round(-1.54));
    //-2
    System.out.println(Math.round(-1.53333333));
    //-1
    System.out.println(Math.round(-1.33333333));
    //-1
    System.out.println(Math.round(-1.43333333));
  }
}
