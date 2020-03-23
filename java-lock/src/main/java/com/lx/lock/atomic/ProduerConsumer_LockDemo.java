package com.lx.lock.atomic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxun
 * Date: 2020/3/8
 * Description:
 */
public class ProduerConsumer_LockDemo {

    public static void main(String[] args){

        Num3 num3 = new Num3();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                num3.increase();
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                num3.decrease();
            }).start();
        }
    }

}

class Num3 {

    private Integer i = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase() {
        try {
            lock.lock();
            while (i != 0){
                condition.await();
            }
            System.out.println("increase " + i++);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrease() {
        try {
            lock.lock();
            while (i == 0){
                condition.await();
            }
            System.out.println("decrease " + i--);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}