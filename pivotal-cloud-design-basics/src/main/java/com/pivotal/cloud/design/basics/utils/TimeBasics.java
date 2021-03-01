package com.pivotal.cloud.design.basics.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 封装Qicloud项目TimeBasics类.<br>
 *
 * <p>//TODO...<br>
 *
 * @author Powered by marklin 2020-08-17 15:53
 * @version 1.0.0
 *     <p>Copyright © 2018-2020 Pivotal Cloud Technology Systems Incorporated. All rights reserved.
 *     <br>
 */
public class TimeBasics {
  public static void main(String[] args) throws ParseException {
    //
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE, 1);
    SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.yyMMddHHmmss);
    String currentTime = dateFormat.format(calendar.getTime());
    System.out.println(currentTime);

    Date lastUpdate =dateFormat.parse("2020-08-17T15:49:00+08:00");
    String updateTime  =dateFormat.format(lastUpdate);

    System.out.println(updateTime);
  }
}
