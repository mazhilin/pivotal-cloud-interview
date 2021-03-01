package com.pivotal.cloud.design.basics;

import com.pivotal.cloud.design.basics.enums.ElementEnum;

/**
 * @className: com.pivotal.cloud.design.basics.ElementBasics
 * @title: ElementBasics
 * @description: 封装Pivotal项目ElementBascics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-28 10:54
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class ElementBasics {

  public static void main(String[] args) {
    int item = 1;
    for (ElementEnum element : ElementEnum.values()) {
      if (item == element.getCode()) {
        System.out.println("{cdoe=" + element.getCode() + ":" + "desc=" + element.getDesc() + "}");
      }
    }
  }
}
