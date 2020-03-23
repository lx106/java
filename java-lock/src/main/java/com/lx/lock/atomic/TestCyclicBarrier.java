package com.lx.lock.atomic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuxun
 * Date: 2020/3/7
 * Description:
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 1; i <= 6; i++) {
            final Integer j = i;
            new Thread(() -> {
                System.out.println("收集龙珠" + j);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
