package com.lx.thread.test;

import java.util.concurrent.TimeUnit;

/**
 * Created with liuxun
 * Description: 测试方法上加锁是否锁住对象
 * Date: 2018-08-26-0:42
 */
public class TestThread1 {

    private Integer i = 127 ;
    private Integer j = 127;

    public synchronized void test1(){
        try {
            System.out.println("test1............");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void test2(){
        try {
            System.out.println("test2............");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test3(){
        synchronized (i){
            try {
                System.out.println("test3............");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void test4(){
        synchronized (j){
            try {
                System.out.println("test4............");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        new Thread(() -> {
            testThread1.test3();
        }).start();

        new Thread(() -> {
            testThread1.test4();
        }).start();

        /*new Thread(() -> {
            testThread1.test1();
        }).start();

        new Thread(() -> {
            testThread1.test2();
        }).start();*/
    }
}
