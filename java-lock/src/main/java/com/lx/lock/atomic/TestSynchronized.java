package com.lx.lock.atomic;

import java.util.concurrent.TimeUnit;

/**
 * @author liuxun
 * Date: 2020/3/7
 * Description:
 */
public class TestSynchronized {

    public synchronized void test1(){
        System.out.println(Thread.currentThread().getName()+"test1");
        test2();
    }

    public synchronized void test2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"test2");
    }

    public static void main(String[] args){

        TestSynchronized testSynchronized = new TestSynchronized();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                testSynchronized.test2();
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                testSynchronized.test1();
            }
        };

        new Thread(runnable,"线程1").start();
        new Thread(runnable2,"线程2").start();

    }
}
