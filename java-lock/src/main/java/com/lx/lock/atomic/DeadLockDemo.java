package com.lx.lock.atomic;

import java.util.concurrent.TimeUnit;

/**
 * @author liuxun
 * Date: 2020/3/9
 * Description:
 */
public class DeadLockDemo {

    public static void main(String[] args) {

        DeadLockDemo deadLockDemo = new DeadLockDemo();
        new Thread(() -> {
            deadLockDemo.method2();
        }).start();

        new Thread(() -> {
            deadLockDemo.method1();
        }).start();
    }

    public synchronized void method1() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method2();
    }

    public synchronized void method2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method1();
    }
}

