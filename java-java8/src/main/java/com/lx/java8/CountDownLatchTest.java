package com.lx.java8;

import java.util.concurrent.CountDownLatch;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-08-05-22:23
 */
public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args){
        /*for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       countDownLatch.await();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName());
               }
           }).start();
        }*/
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new Thread1(countDownLatch));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread1.start();
            countDownLatch.countDown();
        }
    }


}
class Thread1 implements Runnable{
    private  CountDownLatch countDownLatch;
    public Thread1(CountDownLatch countDownLatch) {
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
