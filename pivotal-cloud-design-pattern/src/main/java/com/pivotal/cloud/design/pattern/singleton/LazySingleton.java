package com.pivotal.cloud.design.pattern.singleton;

/**
 * @className: com.pivotal.cloud.design.pattern.singleton.UniqueSingleton
 * @title: UniqueSingleton
 * @description: 封装Pivotal项目UniqueSingleton类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-05-19 19:50
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class LazySingleton implements Singleton {
    /**
     * [1].定义一个静态变量
     */
    private static LazySingleton instance;

    /**
     * [2].封装一个私有构造函数
     */
    private LazySingleton() {
    }

    /**
     * [3].封装静态实例方法进行赋值操作
     *
     * @return InnerSingleton实例对象
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }


    /**
     * [4]定义一个测试方法->innerInvoker
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
        LazySingleton singleton = LazySingleton.getInstance();
        String result = singleton.innerInvoker(request);
        System.out.println("result:" + result);
    }
}
