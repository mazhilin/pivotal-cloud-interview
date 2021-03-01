package com.pivotal.cloud.design.basics.enums;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>封装Qicloud项目SensorElementEnum类.<br></p>
 * <p>//TODO...<br></p>
 *
 * @author Powered by marklin 2020-09-03 17:48
 * @version 1.0.0
 * <p>Copyright © 2018-2020 Pivotal Cloud Technology Systems Incorporated. All rights reserved.<br></p>
 */
public enum SensorElementEnum implements IEnum {
    FS(0, "风速 m/s"), FX(1, "风向 °"), DQWD(2, "大气温度 ℃"), DQSD(3, "大气湿度 %RH"), DQQY(4, "大气气压 hPa"), JYL(5, "降雨量 mm"), JXL(
            6, "降雪量 mm"), ZFL(7, "蒸发量 mm"), GZD(8, "光照度 lux"), ZFS(9, "总辐射 W/㎡"), GHYXFS(10, "光合有效辐射 W/㎡"), ZWFS(11,
            "紫外辐射 W/㎡"), YQHL(12, "氧气含量 %vol"), FYLZ(13, "负氧离子 个/cm3"), COHL(14, "CO含量 ppm"), CO2HL(15,
            "CO2含量 ppm"), PM25(16, "PM2.5 ug/m3"), PM10(17, "PM10 ug/m3"), AQPPM(18,
            "氨气 ppm"), JQPPM(19, "甲醛 ppm"), TRWD(20, "土壤温度 ℃"), TRSD(21, "土壤湿度 %"), TRPH(22,
            "土壤PH值 pH"), TRYFDDL(23, "土壤盐分电导率 mg/L"), SW(24, "水温 ℃"), SPH(25,
            "水PH值 pH"), SZEC(26, "水质EC mg/L"), ZSDB(27, "噪声 dB"), YPWD(28,
            "叶片温度 ℃"), YPSD(29, "叶片湿度 %RH"), SXT(30,
            "摄像头 ㎡"), SXT_FIRST(31, "双摄像头-01 ㎡"), SXT_SECOND(32,
            "双摄像头-02 ㎡"), DLOG(999, "日志");

    private final Integer key;

    private final String name;

    private SensorElementEnum(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public static SensorElementEnum get(int key) {
        for (SensorElementEnum e : SensorElementEnum.values()) {
            if (e.getKey() == key) {
                return e;
            }
        }
        return FS;
    }

    public static String getDesc(int state) {
        SensorElementEnum[] enums = SensorElementEnum.values();
        for (SensorElementEnum en : enums) {
            if (en.getKey() == state) {
                return en.getName();
            }
        }
        return "";
    }

    public static String getName(int state) {
        SensorElementEnum[] items = SensorElementEnum.values();
        for (SensorElementEnum item : items) {
            if (item.getKey() == state) {
                return item.getName();
            }
        }
        return "";
    }

    public static Map<String, String> getKeyVlue() {
        Map<String, String> map = new HashMap<String, String>();
        SensorElementEnum[] items = SensorElementEnum.values();
        for (SensorElementEnum item : items) {
            map.put(item.getKey() + "", item.getName());
        }
        return map;
    }

    public static void main(String[] args) {
        //
        List<Map<String, Object>> elementList = new LinkedList<>();
        Map<String, String> elements = SensorElementEnum.getKeyVlue();
        for (Map.Entry<String, String> element : elements.entrySet()) {
            System.out.println("key= " + element.getKey() + " and value= " + element.getValue());
            String[] elementDesc = SensorElementEnum.getDesc(Integer.parseInt(element.getKey())).split(" ");
            Map<String, Object> elementDataMap = new ConcurrentHashMap<>();
            if (Objects.nonNull(elementDesc)) {
                elementDataMap.put("name", elementDesc[0]);
                elementDataMap.put("unit", elementDesc[1]);
                elementDataMap.put("value", element.getValue());
            }
            elementList.add(elementDataMap);
      System.out.println(elementList.toString());
        }
    }

    @Override
    public Integer getKey() {
        return key;
    }

    @Override
    public String getName() {
        return name;
    }
}
