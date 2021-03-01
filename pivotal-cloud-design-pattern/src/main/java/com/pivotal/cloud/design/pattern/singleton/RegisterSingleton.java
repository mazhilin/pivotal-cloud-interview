package com.pivotal.cloud.design.pattern.singleton;

import org.apache.logging.log4j.util.Strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @className: com.pivotal.cloud.design.pattern.singleton.RegisterSingleton
 * @title: RegisterSingleton
 * @description: 封装Pivotal项目RegisterSingleton类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-08 22:46
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class RegisterSingleton implements Singleton {

    /**
     * [1].使用Collections.synchronizedMap(new HashMap<>())创建线程安全的Map
     */
    private static Map<String, RegisterSingleton> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    /**
     * [2].使用ConcurrentHashMap创建线程安全的Map
     */
    private static Map<String, RegisterSingleton> concurrentHashMap = new ConcurrentHashMap<>();
    /**
     * [3].使用Hashtable创建线程安全的Map
     */
    private static Map<String,RegisterSingleton> hashtable=new Hashtable<>();

    /**
     * [3].使用静态代码块加载类实例
     */
    static {
        RegisterSingleton singleton = new RegisterSingleton();
        String name = singleton.getClass().getName();
        synchronizedMap.put(name, singleton);
    }

    /**
     * [4].封装一个私有构造函数
     */
    private RegisterSingleton() {

    }

    public static RegisterSingleton getObject(String name) {
        if (Strings.isNotEmpty(name)) {
            name = RegisterSingleton.class.getName();
        }
        if (null == synchronizedMap.get(name)) {
            try {
                synchronizedMap.put(name, (RegisterSingleton) Class.forName(name).newInstance());
                System.out.println("进来了第一次");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return synchronizedMap.get(name);
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
        //
        String request = "123";
        RegisterSingleton singleton = RegisterSingleton.getObject(request);
        String result = singleton.innerInvoker(request);
        System.out.println("result:" + result);
        System.out.println(1 << 4);
        System.out.println(1 << 6);
        System.out.println(1 << 8);
        System.out.println(1 << 10);
        System.out.println(1 << 13);

    }
}
