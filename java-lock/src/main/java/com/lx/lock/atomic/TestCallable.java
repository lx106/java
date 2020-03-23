package com.lx.lock.atomic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

	public static void main(String[] args) {
        CallableDemo cd = new  CallableDemo();
		FutureTask<Integer> task = new FutureTask<Integer>(cd);
		new Thread(task).start();
		System.out.println("--------------------");
  
		try {
			System.out.println(task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------");

		
	}
}
class CallableDemo implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0 ;
		Thread.sleep(2000);
		for (int i = 0; i < 1000000000; i++) {
			sum += i;
		}
		return sum;
	}
	
}
class ThreadDemo1 implements Runnable{

	@Override
	public void run() {
		
	}
}