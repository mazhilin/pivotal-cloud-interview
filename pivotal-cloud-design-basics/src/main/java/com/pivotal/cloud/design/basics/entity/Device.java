package com.pivotal.cloud.design.basics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @className: com.pivotal.cloud.design.basics.entity.Device
 * @title: Device
 * @description: 封装Pivotal项目Device类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-29 10:54
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device implements Entity {
  private String appId;
  private String productType;
  private String simCard;
  /** 传感器信息-sensors */
  private List<Sensor> sensors;
}
