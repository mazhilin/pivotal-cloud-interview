package com.pivotal.cloud.design.basics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @className: com.pivotal.cloud.design.basics.entity.Sensor
 * @title: Sensor
 * @description: 封装Pivotal项目Sensor类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-29 10:51
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor implements Entity {
  private static final long serialVersionUID = 7656227489944228243L;
  private Integer id;
  /**
   * 传感器要素
   *
   * <p>elements
   */
  private List<Element> elements;
}
