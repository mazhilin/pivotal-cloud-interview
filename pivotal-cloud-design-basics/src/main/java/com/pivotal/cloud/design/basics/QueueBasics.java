package com.pivotal.cloud.design.basics;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @className: com.pivotal.cloud.design.basics.QueueBasics
 * @title: QueueBasics
 * @description: 封装Pivotal项目QueueBasics类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-06 00:29
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class QueueBasics {
    public static void main(String[] args) {
        //
        Queue<String> queue = new LinkedBlockingDeque<String>();
        //[1].offer-> queue.offer():添加元素
        queue.offer("queue-server");
        //[2].add-> queue.add():添加元素
        //一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝,调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。
        queue.add("queue-client");
        for (String item : queue) {
            System.out.println("queue=" + item);
        }
        //[3].poll->queue.poll():返回第一个元素，并在队列中删除返回的对象，没有元素 poll()会返回 null
        System.out.println("queue poll=" + queue.poll());
        //[4].remove->queue.remove():返回第一个元素，并在队列中删除返回的对象，没有元素remove直接抛出java.util.NoSuchElementException异常。
        System.out.println("queue remove=" + queue.remove());
        //[5].element->queue.element():查询队列的头部元素，并且返回第一个元素，在队列为空时，element直接抛出java.util.NoSuchElementException异常
        System.out.println("queue element=" + queue.element());
        //[6].peek->queue.peek():查询队列的头部元素，返回第一个元素,在队列为空时，peek返回null
        System.out.println("queue peek=" + queue.peek());
        //[7].size->queue.size():查询队列元素大小
        System.out.println("queue size=" +queue.size());
    }
}
