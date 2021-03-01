package com.pivotal.cloud.design.basics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @className: com.pivotal.cloud.design.basics.HashMapBasics
 * @title: HashMapBasics
 * @description: 封装Pivotal项目HashMapBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-06 02:35
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class HashMapBasics {
    protected static void mergeMap(Map<String, Object> params, Map<String, Object> results) {
        if (Objects.isNull(results)) {
            results = new ConcurrentHashMap<>();
        }
        if (Objects.isNull(params)) {
            return;
        }
        Iterator iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            results.put(String.valueOf(key), params.get(key) != null ? params.get(key) : "");
        }
    }

    public static void main(String[] args) {
        //
/*
        HashMap<String,String> hashMap=new HashMap<String,String>();
        hashMap.put("张三","张三");
        hashMap.put("李四","李四");
        hashMap.put("王五","王五");
        hashMap.put("赵六","赵六");
        hashMap.put("谢七","谢七");
        System.out.println(hashMap.get("张三"));

        for (String key:hashMap.keySet()) {
            Integer hash=key.hashCode();
            Integer index=hash%8;
            System.out.println(String.format("%s的哈希值是%s,取模后index is %s",key,hash,index));
        }
*/

        Map<String, Object> params = new HashMap<>();
        params.put("farmId", "123456");
        params.put("sn", "SN123456");

        Map<String, Object> results = new HashMap<>();
        params.put("air", "12");
        params.put("wh", "12");

        mergeMap(params, results);

        System.out.println(params);

        System.out.println(results);
    }
}
