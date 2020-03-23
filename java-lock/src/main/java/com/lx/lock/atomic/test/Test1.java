package com.lx.lock.atomic.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxun
 * Date: 2020/3/8
 * Description: A,B,C 三个线程  A 打印 5 次  B 打印 10次  C 打印 15 次  循环 10 次
 */
public class Test1 {


    public static void main(String[] args) throws InterruptedException {


        Print print = new Print();
        print.i = 1;

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.lock.lock();
                try {
                    while (print.i != 1) {
                        print.conditionA.await();
                    }
                    for (int i1 = 0; i1 < 5; i1++) {
                        print.print();
                    }
                    print.i = 2;
                    print.conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    print.lock.unlock();
                    System.out.println("unlock");
                }
            }
        }, "线程A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.lock.lock();
                try {
                    while (print.i != 2) {
                        print.conditionB.await();
                    }
                    for (int i1 = 0; i1 < 10; i1++) {
                        print.print();
                    }
                    print.i = 3;
                    print.conditionC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    print.lock.unlock();
                }
            }
        }, "线程B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.lock.lock();
                try {
                    while (print.i != 3) {
                        print.conditionC.await();
                    }
                    for (int i1 = 0; i1 < 15; i1++) {
                        print.print();
                    }
                    print.i = 1;
                    print.conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    print.lock.unlock();
                }
            }
        }, "线程C").start();

    }

}

class Print {

    public Lock lock = new ReentrantLock();
    public volatile int i;

    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    public Condition conditionC = lock.newCondition();

    public Lock getLock() {
        return lock;
    }

    public void print() {
        System.out.println(Thread.currentThread().getName() + " 正在打印");
    }

}
