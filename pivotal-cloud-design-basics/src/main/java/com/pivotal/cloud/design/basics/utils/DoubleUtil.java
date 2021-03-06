package com.pivotal.cloud.design.basics.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @className: com.pivotal.cloud.design.basics.utils.DoubleUtil
 * @title: DoubleUtil
 * @description: 封装Pivotal项目DoubleUtil类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-29 16:06
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class DoubleUtil {
// 默认除法运算精度
private static final int DEF_DIV_SCALE = 10;

private DoubleUtil() {
}

public static DoubleUtil getInstance() {
  return DoubleHolder.currentInstance;
}

/**
 * 提供精确的加法运算。
 *
 * @param v1 被加数
 * @param v2 加数
 * @return 两个参数的和
 */
public double add(double v1, double v2) {
  BigDecimal b1 = BigDecimal.valueOf(v1);
  BigDecimal b2 = BigDecimal.valueOf(v2);
  return b1.add(b2).doubleValue();
}

/**
 * 提供精确的减法运算。
 *
 * @param v1 被减数
 * @param v2 减数
 * @return 两个参数的差
 */
public double sub(double v1, double v2) {
  BigDecimal b1 = BigDecimal.valueOf(v1);
  BigDecimal b2 = BigDecimal.valueOf(v2);
  return b1.subtract(b2).doubleValue();
}

/**
 * 提供精确的乘法运算。
 *
 * @param v1 被乘数
 * @param v2 乘数
 * @return 两个参数的积
 */
public double mul(double v1, double v2) {
  BigDecimal b1 = BigDecimal.valueOf(v1);
  BigDecimal b2 = BigDecimal.valueOf(v2);
  return b1.multiply(b2).doubleValue();
}

/**
 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
 * 小数点以后10位，以后的数字四舍五入。
 *
 * @param v1 被除数
 * @param v2 除数
 * @return 两个参数的商
 */
public double div(double v1, double v2) {
  return div(v1, v2, DEF_DIV_SCALE);
}

/**
 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
 * 定精度，以后的数字四舍五入。
 *
 * @param v1    被除数
 * @param v2    除数
 * @param scale 表示表示需要精确到小数点以后几位。
 * @return 两个参数的商
 */
public double div(double v1, double v2, int scale) {
  if (scale < 0) {
    throw new IllegalArgumentException("The scale must be a positive integer or zero");
  }
  BigDecimal b1 = BigDecimal.valueOf(v1);
  BigDecimal b2 = BigDecimal.valueOf(v1);
  return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
}

/**
 * 提供精确的小数位四舍五入处理。
 *
 * @param v     需要四舍五入的数字
 * @param scale 小数点后保留几位
 * @return 四舍五入后的结果
 */
public double round(double v, int scale) {
  
  if (scale < 0) {
    throw new IllegalArgumentException("The scale must be a positive integer or zero");
  }
  BigDecimal b = BigDecimal.valueOf(v);
  BigDecimal one = new BigDecimal("1");
  return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
}

public String roundByScale(double v, int scale) {
  if (scale < 0) {
    throw new IllegalArgumentException(
            "The   scale   must   be   a   positive   integer   or   zero");
  }
  if (scale == 0) {
    return new DecimalFormat("0").format(v);
  }
  String formatStr = "0.";
  for (int i = 0; i < scale; i++) {
    formatStr = formatStr + "0";
  }
  return new DecimalFormat(formatStr).format(v);
}

private static class DoubleHolder {
  private static final DoubleUtil currentInstance = new DoubleUtil();
}
}
