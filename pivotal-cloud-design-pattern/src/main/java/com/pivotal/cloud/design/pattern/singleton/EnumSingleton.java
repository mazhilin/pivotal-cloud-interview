package com.pivotal.cloud.design.pattern.singleton;

/**
 * @className: com.pivotal.cloud.design.pattern.singleton.EnumSingleton
 * @title: EnumSingleton
 * @description: 封装Pivotal项目EnumSingleton类
 * @content: 基于枚举类类型实现EnumSingleton单例模式
 * @author: marklin
 * @datetime: 2020-05-19 20:05
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public enum EnumSingleton implements Singleton {
    /**
     * [1].定义一个枚举常量类
     */
    INSTANCE;

    /**
     * [2]定义一个测试方法->innerInvoker
     *
     * @param request 参数request
     * @return 返回结果
     */
    public String innerInvoker(String request) {
        String index = "456";
        System.out.println("request:" + request);
        request = request + index;
        return request;
    }

    public static void main(String[] args) {
        String request = "123";
        System.out.println("result:" + EnumSingleton.INSTANCE.innerInvoker(request));
    }
}
