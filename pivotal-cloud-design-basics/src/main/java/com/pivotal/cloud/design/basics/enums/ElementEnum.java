package com.pivotal.cloud.design.basics.enums;

/**
 * @className: com.pivotal.cloud.design.basics.enums.ElementEnum
 * @title: ElementEnum
 * @description: 封装Pivotal项目ElementEnum类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-28 10:51
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public enum ElementEnum {
  FS(0, "风速 m/s"),
  FX(1, "风向 °"),
  DQWD(2, "大气温度 ℃"),
  DQSD(3, "大气湿度 %RH"),
  DQQY(4, "大气气压 hPa"),
  JYL(5, "降雨量 mm"),
  JXL(6, "降雪量 mm"),
  ZFL(7, "蒸发量 mm"),
  GZD(8, "光照度 lux"),
  ZFS(9, "总辐射 W/㎡"),
  GHYXFS(10, "光合有效辐射 W/㎡"),
  ZWFS(11, "紫外辐射 W/㎡"),
  YQHL(12, "氧气含量 %vol"),
  FYLZ(13, "负氧离子 个/cm3"),
  COHL(14, "CO含量 ppm"),
  CO2HL(15, "CO2含量 ppm"),
  PM25(16, "PM¬¬2.5 ug/m3"),
  PM10(17, "PM10 ug/m3"),
  AQPPM(18, "氨气 ppm"),
  JQPPM(19, "甲醛 ppm"),
  TRWD(20, "土壤温度 ℃"),
  TRSD(21, "土壤湿度 %"),
  TRPH(22, "土壤PH值 pH"),
  TRYFDDL(23, "土壤盐分电导率 mg/L"),
  SW(24, "水温 ℃"),
  SPH(25, "水PH值 pH"),
  SZEC(26, "水质EC mg/L"),
  ZSDB(27, "噪声 dB"),
  YPWD(28, "叶片温度 ℃"),
  YPSD(29, "叶片湿度 %RH"),
  SXT(30, "摄像头 ㎡"),
  SXT_FIRST(31, "双摄像头-01 ㎡"),
  SXT_SECOND(32, "双摄像头-02 ㎡"),
  DLOG(999, "日志");
  private Integer code;

  private String desc;

  ElementEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
