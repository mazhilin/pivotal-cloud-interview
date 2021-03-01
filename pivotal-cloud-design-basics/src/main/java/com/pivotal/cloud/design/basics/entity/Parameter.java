package com.pivotal.cloud.design.basics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: com.pivotal.cloud.design.basics.entity.Parameter
 * @title: Parameter
 * @description: 封装Pivotal项目Parameter类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-29 10:43
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameter implements Entity {
  private static final long serialVersionUID = -7714419483307124104L;
  /**
   * 要素采集时间-年
   *
   * <p>year
   */
  private Integer year;
  /**
   * 要素采集时间-月
   *
   * <p>month
   */
  private Integer month;
  /**
   * 要素采集时间-日
   *
   * <p>day
   */
  private Integer day;
  /**
   * 要素采集时间-时
   *
   * <p>hour
   */
  private Integer hour;
  /**
   * 要素采集时间-分
   *
   * <p>minute
   */
  private Integer minute;
  /**
   * 要素采集时间-秒
   *
   * <p>second
   */
  private Integer second;
  /**
   * 要素数据内容
   *
   * <p>content
   */
  private String content;
}
