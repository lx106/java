package com.lx.lock.atomic;

/**
 * @author liuxun
 * Date: 2020/3/7
 * Description: 传统生产消费者
 */
public class ProduerConsumer_SynchronizedDemo {

    public static void main(String[] args) {

        Num num = new Num(0);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                num.increase();
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                num.decrease();
            }).start();
        }
    }

}

class Num {

    public Integer i;

    public Num(Integer i) {
        this.i = i;
    }

    public Integer getI() {
        return i;
    }

    public synchronized void increase() {
        try {
            while (getI() == 1) {
                this.wait();
            }
            System.out.println("increase" + i++);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.notifyAll();
        }
    }

    public synchronized void decrease() {
        try {
            while (getI() == 0) {
                this.wait();
            }
            System.out.println("decrease" + --i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.notifyAll();
        }
    }
}