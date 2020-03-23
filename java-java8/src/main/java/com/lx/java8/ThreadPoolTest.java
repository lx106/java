package com.lx.java8;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-08-05-22:01
 */
public class ThreadPoolTest {

    @Test
    public void test1(){
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date()+Thread.currentThread().getName());
            }
        },0,5, TimeUnit.SECONDS);
    }

    public static void main(String[] args){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        scheduledExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        });

        scheduledExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("222");
            }
        });



    }

}
