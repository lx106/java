package com.example.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-05-25-10:45
 * count 共享变量 有无count
 */
public class TestVolatile {
    private static volatile Integer count = 0;
    private static Integer count2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable[] runnables = new Runnable[100];
        for (int i = 0; i < 100; i++) {
            runnables[i] = () -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    count++;
                    count2++;
                }
            };
        }
        for (int i = 0; i < 10; i++) {
            new Thread(runnables[i]).start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(count+":"+count2);
    }
}
