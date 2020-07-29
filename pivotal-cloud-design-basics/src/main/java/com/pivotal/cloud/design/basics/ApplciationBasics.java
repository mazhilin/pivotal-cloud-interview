package com.pivotal.cloud.design.basics;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pivotal.cloud.design.basics.entity.Device;
import com.pivotal.cloud.design.basics.entity.Element;
import com.pivotal.cloud.design.basics.entity.Parameter;
import com.pivotal.cloud.design.basics.entity.Sensor;
import com.pivotal.cloud.design.basics.enums.ElementEnum;
import com.pivotal.cloud.design.basics.utils.DoubleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.pivotal.cloud.design.basics.enums.ElementEnum.FS;

/**
 * @className: com.pivotal.cloud.design.basics.ApplciationBasics
 * @title: ApplciationBasics
 * @description: 封装Pivotal项目ApplciationBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-29 11:02
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class ApplciationBasics {
  private static final Logger logger = LoggerFactory.getLogger(ParameterBasics.class);

  public static double round(double v, int scale) {

    if (scale < 0) {
      throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
    BigDecimal b = new BigDecimal(Double.toString(v));
    BigDecimal one = new BigDecimal("1");
    return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
  }

  public static String roundByScale(double v, int scale) {
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

  public static void main(String[] args) {
    // 构建风速相关参数数据
    Parameter parameterfs = new Parameter();
    parameterfs.setContent("15");
    Parameter parameterfs2 = new Parameter();
    parameterfs2.setContent("12");
    Parameter parameterfs3 = new Parameter();
    parameterfs3.setContent("13");

    Parameter parameterzfs = new Parameter();
    parameterzfs.setContent("27");
    Parameter parameterzfs2 = new Parameter();
    parameterzfs2.setContent("17");

    Parameter parameterdqwd = new Parameter();
    parameterdqwd.setContent("27.00");
    Parameter parameterdqwd2 = new Parameter();
    parameterdqwd2.setContent("17.00");

    Element elementfs = new Element();
    elementfs.setType(FS.getCode());
    List<Parameter> parameterFsList = new ArrayList<>();
    parameterFsList.add(parameterfs);
    parameterFsList.add(parameterfs2);
    parameterFsList.add(parameterfs3);
    elementfs.setParameters(parameterFsList);

    Element elementzfs = new Element();
    elementzfs.setType(ElementEnum.ZFS.getCode());
    List<Parameter> parameterZfsList = new ArrayList<>();
    parameterZfsList.add(parameterzfs);
    parameterZfsList.add(parameterzfs2);
    elementzfs.setParameters(parameterZfsList);

    Element elementdqwd = new Element();
    elementdqwd.setType(ElementEnum.DQWD.getCode());
    List<Parameter> parameterDqwdList = new ArrayList<>();
    parameterDqwdList.add(parameterdqwd);
    parameterDqwdList.add(parameterdqwd2);
    elementdqwd.setParameters(parameterDqwdList);

    Sensor sensorFs = new Sensor();
    sensorFs.setId(1);
    List<Element> elementFsList = new ArrayList<>();
    elementFsList.add(elementfs);
    sensorFs.setElements(elementFsList);

    Sensor sensorZfs = new Sensor();
    sensorZfs.setId(2);
    List<Element> elementZfsList = new ArrayList<>();
    elementZfsList.add(elementzfs);
    sensorZfs.setElements(elementZfsList);

    Sensor sensorDqwd = new Sensor();
    sensorDqwd.setId(3);
    List<Element> elementQdwdList = new ArrayList<>();
    elementQdwdList.add(elementdqwd);
    sensorDqwd.setElements(elementQdwdList);

    Device device = new Device();
    device.setAppId("DEV202007290001");
    device.setProductType("1");
    List<Sensor> sensorList = new ArrayList<>();
    sensorList.add(sensorFs);
    sensorList.add(sensorDqwd);
    sensorList.add(sensorZfs);
    device.setSensors(sensorList);
    device.setSimCard("15286774061");
    System.out.println(
        JSON.toJSONString(
            device,
            SerializerFeature.PrettyFormat,
            SerializerFeature.DisableCircularReferenceDetect));
    logger.info(
        "json={}", JSON.toJSONString(device, SerializerFeature.DisableCircularReferenceDetect));
    
    sensorList.parallelStream()
        .filter(Objects::nonNull)
        .forEach(
            sensor -> {
              if (Objects.nonNull(sensor.getElements())) {
                sensor.getElements().parallelStream()
                    .filter(Objects::nonNull)
                    .forEach(
                        element -> {
                          if (Objects.nonNull(element.getParameters())) {
                            element.getParameters().parallelStream()
                                .filter(Objects::nonNull)
                                .forEach(
                                    parameter -> {
                                      parameter.getContent();
                                      System.out.println(
                                          "type="
                                              + element.getType()
                                              + "，content="
                                              + parameter.getContent());
                                    });
                            /*            // 利用集合中某个元素求取总数
                            int amount =
                                    element.getParameters().parallelStream().mapToInt(Parameter -> Integer.valueOf(Parameter.getContent())).sum();
                            System.out.println("type=" + element.getType() + "，amount=" + amount);*/
                            // 利用集合中的某一个元素求取平均值
                            double averageCount =
                                element.getParameters().parallelStream()
                                    .mapToDouble(
                                        Parameter -> Double.parseDouble(Parameter.getContent()))
                                    .average()
                                    .getAsDouble();
                            BigDecimal averageQuota =
                                BigDecimal.valueOf(DoubleUtil.getInstance().round(averageCount, 2))
                                    .stripTrailingZeros();
                            System.out.println(
                                "type="
                                    + element.getType()
                                    + "，avg="
                                    + averageQuota.toPlainString());
                          }
                        });
              }
            });
  }
}
