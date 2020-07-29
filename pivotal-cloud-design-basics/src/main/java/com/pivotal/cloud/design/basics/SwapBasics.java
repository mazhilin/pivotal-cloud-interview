package com.pivotal.cloud.design.basics;

/**
 * @className: com.pivotal.cloud.design.basics.SwapBasics
 * @title: SwapBasics
 * @description: 封装Pivotal项目SwapBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-06 01:03
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class SwapBasics {
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void change(int[] array) {
        // 将数组的第一个元素变为0
        array[0] = 0;
    }

    public static void main(String[] args) {
        //
        int num1 = 10;
        int num2 = 20;
        swap(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("arr="+arr[0]);
        change(arr);
        System.out.println("arr res="+arr[0]);
    }
}
