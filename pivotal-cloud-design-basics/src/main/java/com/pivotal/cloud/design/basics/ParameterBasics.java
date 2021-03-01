package com.pivotal.cloud.design.basics;

import com.pivotal.cloud.design.basics.enums.ElementEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.util.*;

/**
 * @className: com.pivotal.cloud.design.basics.ParameterBasics
 * @title: ParameterBasics
 * @description: 封装Pivotal项目ParameterBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-28 14:35
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class ParameterBasics {

  private static final Logger logger = LoggerFactory.getLogger(ParameterBasics.class);

  public static void testParams(String paramValue) throws InterruptedException {
    StopWatch watch = new StopWatch();
    watch.start();
    Thread.sleep(100);
    paramValue += paramValue + "456";
    System.out.println(paramValue);
    watch.stop();
    System.out.println(watch.prettyPrint());
  }

  public static void testDate(Date date) throws InterruptedException {
    StopWatch watch = new StopWatch();
    watch.start();
    Thread.sleep(100);
    watch.stop();
    System.out.println(watch.prettyPrint());
  }

  public static void main(String[] args) {
    String params = "123";
    try {
      ParameterBasics.testParams(params);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      ParameterBasics.testParams("123");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    logger.info(ElementEnum.FS.getCode() + ElementEnum.FS.getDesc());

    List<Map<String, Object>> mapList = new ArrayList<>(1);
    Map<String, Object> map = new HashMap<>();
    map.put("element-wd", "36.7");
    map.put("element-lux", 20);
    mapList.add(map);
    mapList.stream()
        .filter(Objects::nonNull)
        .forEachOrdered(
            item -> {
              System.out.println(item.entrySet());
            });
    
    String retInt="123";
    String reqInt="123";
    BigDecimal decimalStr11 =new BigDecimal(retInt);
    BigDecimal decimalStr22 =new BigDecimal(reqInt);
    System.out.println(retInt+reqInt);
    System.out.println(Integer.parseInt(retInt)+Integer.parseInt(reqInt));
    System.out.println(decimalStr11.add(decimalStr22));
  
    String retDub="123.00";
    String reqDub="123.00";
    BigDecimal decimalStr1 =new BigDecimal(reqDub);
    BigDecimal decimalStr2 =new BigDecimal(retDub);
    System.out.println(decimalStr1.add(decimalStr2));
    
    
    
    
    
  }
}
