package com.pivotal.cloud.design.basics;

import com.pivotal.cloud.design.basics.entity.Device;
import com.pivotal.cloud.design.basics.entity.Element;
import com.pivotal.cloud.design.basics.entity.Parameter;
import com.pivotal.cloud.design.basics.entity.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.pivotal.cloud.design.basics.enums.ElementEnum.FS;

/**
 * @className: com.pivotal.cloud.design.basics.StreamBasics
 * @title: StreamBasics
 * @description: 封装Pivotal项目StreamBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-29 17:13
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class StreamBasics {
  private static final Logger logger = LoggerFactory.getLogger(ParameterBasics.class);

  /**
   * consume-过滤器实现
   *
   * @param i 参数
   * @return
   */
  private static void consume(int i) {
    try {
      TimeUnit.SECONDS.sleep(i);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    System.out.println(i);
  }

  /**
   * filter-过滤器实现
   *
   * @param i 参数
   * @return
   */
  private static boolean filter(int i) {
    try {
      TimeUnit.SECONDS.sleep(i);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return i % 2 == 0;
  }

  public static void main(String[] args) throws InterruptedException {
    // 构建风速相关参数数据
    Parameter parameter = new Parameter();
    parameter.setContent("15");
    Element element = new Element();
    element.setType(FS.getCode());
    List<Parameter> parameterList = new ArrayList<>();
    parameterList.add(parameter);
    element.setParameters(parameterList);
    Sensor sensor = new Sensor();
    sensor.setId(1);
    List<Element> elementList = new ArrayList<>();
    elementList.add(element);
    sensor.setElements(elementList);

    Device device = new Device();
    device.setAppId("DEV202007290001");
    device.setProductType("1");
    List<Sensor> sensorList = new ArrayList<>();
    sensorList.add(sensor);
    device.setSensors(sensorList);
    device.setSimCard("15286774061");
    /*    System.out.println(
        JSON.toJSONString(
            device,
            SerializerFeature.PrettyFormat,
            SerializerFeature.DisableCircularReferenceDetect));
    logger.info(
        "json={}", JSON.toJSONString(device, SerializerFeature.DisableCircularReferenceDetect));*/
      
    // [1]filter+foreach
    StopWatch watch = new StopWatch();
    watch.start("stream+filter+forEach:-----begin");
    sensorList.stream()
        .filter(Objects::nonNull)
        .forEach(
            sensorItem -> {
              if (Objects.nonNull(sensorItem.getElements())) {
                sensorItem.getElements().stream()
                    .filter(Objects::nonNull)
                    .forEach(
                        elementItem -> {
                          elementItem.getParameters().stream()
                              .filter(Objects::nonNull)
                              .forEach(
                                  parameterItem -> {
                                    Integer type = elementItem.getType();
                                    String content = parameterItem.getContent();
                                    System.out.println("type=" + type + ":content=" + content);
                                  });
                        });
              }
            });
    watch.stop();
    logger.info("stream+filter+forEach->watch-log:{}", watch.prettyPrint());
    watch.start("parallelStream+filter+forEach:-----begin");
    sensorList.parallelStream()
        .filter(Objects::nonNull)
        .forEach(
            sensorItem -> {
              if (Objects.nonNull(sensorItem.getElements())) {
                sensorItem.getElements().parallelStream()
                    .filter(Objects::nonNull)
                    .forEach(
                        elementItem -> {
                          elementItem.getParameters().parallelStream()
                              .filter(Objects::nonNull)
                              .forEach(
                                  parameterItem -> {
                                    Integer type = elementItem.getType();
                                    String content = parameterItem.getContent();
                                    System.out.println("type=" + type + ":content=" + content);
                                  });
                        });
              }
            });
    watch.stop();
    logger.info("parallelStream+filter+forEach->watch-log:{}", watch.prettyPrint());
    watch.start("parallelStream+filter+forEachOrdered:-----begin");
    sensorList.parallelStream()
        .filter(Objects::nonNull)
        .forEachOrdered(
            sensorItem -> {
              if (Objects.nonNull(sensorItem.getElements())) {
                sensorItem.getElements().parallelStream()
                    .filter(Objects::nonNull)
                    .forEachOrdered(
                        elementItem -> {
                          elementItem.getParameters().parallelStream()
                              .filter(Objects::nonNull)
                              .forEachOrdered(
                                  parameterItem -> {
                                    Integer type = elementItem.getType();
                                    String content = parameterItem.getContent();
                                    System.out.println("type=" + type + ":content=" + content);
                                  });
                        });
              }
            });
    watch.stop();
    logger.info("parallelStream+filter+forEachOrdered->watch-log:{}", watch.prettyPrint());
  }
}
