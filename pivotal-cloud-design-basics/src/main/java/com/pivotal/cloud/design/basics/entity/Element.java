package com.pivotal.cloud.design.basics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @className: com.pivotal.cloud.design.basics.entity.Element
 * @title: Element
 * @description: 封装Pivotal项目Element类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-29 10:41
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Element implements Entity {
  private static final long serialVersionUID = -1867228009051364262L;
  private Integer type;
  private List<Parameter> parameters;
}
