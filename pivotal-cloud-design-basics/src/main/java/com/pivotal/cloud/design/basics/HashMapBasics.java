package com.pivotal.cloud.design.basics;

import java.util.HashMap;
import java.util.Map;

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
    public static void main(String[] args) {
        //
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
    }
}
