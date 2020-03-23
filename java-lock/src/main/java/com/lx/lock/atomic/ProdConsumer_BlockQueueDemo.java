package com.lx.lock.atomic;

import java.util.concurrent.SynchronousQueue;

/**
 * @author liuxun
 * Date: 2020/3/8
 * Description:
 */
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args){

        Num2 num2 = new Num2(new SynchronousQueue());

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                num2.increase();
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                num2.decrease();
            }).start();
        }
    }
}

class Num2{

    private SynchronousQueue synchronousQueue;

    public Num2(SynchronousQueue synchronousQueue) {
        this.synchronousQueue = synchronousQueue;
    }

    public void increase(){
        try {
            synchronousQueue.put(1);
            System.out.println("put");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void decrease(){
        try {
            synchronousQueue.take();
            System.out.println("take");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
