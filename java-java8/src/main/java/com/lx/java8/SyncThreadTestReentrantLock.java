package com.lx.java8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncThreadTestReentrantLock {
    private static Lock lock = new ReentrantLock();
	private static String state = "A";
	private static Condition A = lock.newCondition();
	private static Condition B = lock.newCondition();
	private static Condition C = lock.newCondition();
	public static void main(String[] args) throws InterruptedException {
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		ThreadC c = new ThreadC();

		a.start();
		b.start();
		c.start();
	}

	static class ThreadA extends Thread {
		@Override
		public void run() {
			lock.lock();
			if (state.equals("A")){
				System.out.println("A");
				state = "B";
				B.signal();
			}else {
				try {
					A.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lock.unlock();
		}
	}
	static class ThreadB extends Thread {
		@Override
		public void run() {
			lock.lock();
			if (state.equals("B")){
				System.out.println("B");
				state = "C";
				C.signal();
			}else {
				try {
					B.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lock.unlock();
		}
	}
	static class ThreadC extends Thread {
		@Override
		public void run() {
			lock.lock();
			if (state.equals("C")){
				System.out.println("C");
				state = "A";
				A.signal();
			}else {
				try {
					C.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lock.unlock();
		}
	}
}

