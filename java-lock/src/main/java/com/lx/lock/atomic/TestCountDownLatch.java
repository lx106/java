package com.lx.lock.atomic;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
   
	public static void main(String[] args) {
		
	    final CountDownLatch latch = new CountDownLatch(5);
		LatchDemo ld = new LatchDemo(latch);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			new Thread(ld).start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("一共耗时：" +(end - start));
	}
}
class LatchDemo implements Runnable{

	private CountDownLatch latch ;
	
	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		
    	try {
			for (int i = 0; i < 5000; i++) {
				if (i % 2 == 0) {
					System.out.println(i);
				}
			} 
		} finally {
			this.latch.countDown();
		}	
	}
	
}
