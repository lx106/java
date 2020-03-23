package com.lx.lock.atomic;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxun
 * Date: 2020/3/7
 * Description:
 */
public class SemaphoreDemo {

    public static void main(String[] args){

        Semaphore semaphore = new Semaphore(2);

        System.out.println("一共2个停车位");
        for (int i = 0; i < 10; i++) {
            final int j=i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("车辆"+Thread.currentThread().getName()+"     抢到停车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("车辆"+Thread.currentThread().getName()+"    3秒后离开了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(j)).start();
        }
    }

}
