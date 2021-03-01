package com.pivotal.cloud.design.pattern.singleton;

/**
 * @className: com.pivotal.cloud.design.pattern.singleton.LockSingleton
 * @title: LockSingleton
 * @description: 封装Pivotal项目LockSingleton类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-05-19 20:01
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class LockSingleton implements Singleton {
    /**
     * [1].定义一个静态变量
     */
    private static LockSingleton instance;

    /**
     * [2].封装一个私有构造函数
     */
    private LockSingleton() {
    }

    /**
     * [3].封装静态实例方法进行赋值操作
     *
     * @return InnerSingleton实例对象
     */
    public static LockSingleton getInstance() {
        if (instance == null) {
            synchronized (LockSingleton.class) {
                if (instance == null) {
                    instance = new LockSingleton();
                }
            }
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
        LockSingleton singleton = LockSingleton.getInstance();
        String result = singleton.innerInvoker(request);
        System.out.println("result:" + result);
    }
}
