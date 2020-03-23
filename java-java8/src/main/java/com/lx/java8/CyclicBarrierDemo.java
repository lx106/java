package com.lx.java8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static final int INIT_SIZE = 4;
    private static CyclicBarrier barrier;

    public static void main(String[] args) {
        System.out.println("开启CyclicBarrier屏障（裁判员就位）");
        barrier = new CyclicBarrier(INIT_SIZE, new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程通知:所有线程都已经准备好了,CyclicBarrier屏障去除（所有运动员都准备完毕，发信号枪）");
            }
        });
        for (int i=0;i<8;i++){
            new ThreadDemo().start();
        }

    }

    static class ThreadDemo extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+"线程准备好了,等待CyclicBarrier屏障去除（一名运动员准备好了）");
                barrier.await();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"线程继续运行（开始跑）");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}