package com.lx.lock.atomic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author liuxun
 * Date: 2020/3/7
 * Description:
 */
public class BlockingQueueDemo {

    public static void main(String[] args){
        BlockingQueue blockingQueue = new ArrayBlockingQueue<String>(3);

//        blockingQueue.add("a");
//        blockingQueue.add("b");
//        blockingQueue.add("c");
//
//        System.out.println(blockingQueue.element());
//
//       //  full add 方法会抛出异常
//        blockingQueue.add("x");

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

    }
}
