package com.pivotal.cloud.design.pattern.singleton;

/**
 * @className: com.pivotal.cloud.design.pattern.singleton.StaticSingleton
 * @title: StaticSingleton
 * @description: 封装Pivotal项目StaticSingleton类
 * @content: 基于静态内部类实现InnerSingleton单例模式：
 * <br>[1].定义一个静态内部类</br>
 * <br>[2].封装一个私有构造函数</br>
 * <br>[3].封装静态实例方法进行赋值操作</br>
 * @author: marklin
 * @datetime: 2020-05-19 20:03
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class InnerSingleton implements Singleton {
    /**
     * [1].定义一个静态内部类
     */
    private static class InnerSingletonHolder {
        private static InnerSingleton instance = new InnerSingleton();
    }

    /**
     * [2].封装一个私有构造函数
     */
    private InnerSingleton() {
    }

    /**
     * [3].封装静态实例方法进行赋值操作
     *
     * @return InnerSingleton实例对象
     */
    public static InnerSingleton getInstance() {
        return InnerSingletonHolder.instance;
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
        InnerSingleton singleton = InnerSingleton.getInstance();
        String result = singleton.innerInvoker(request);
        System.out.println("result:" + result);
    }
}
