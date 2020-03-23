package com.example.java8;

import org.junit.Test;

public class TestConstructor2 {

	@Test
	public void test1(){
		
		Runnable r1 = () ->  { 
			for (int i = 0; i < 10; i++) {
				System.out.println("####"+i);
			}
		};
		Runnable r2 = () ->  { 
			for (int i = 0; i < 10; i++) {
				System.out.println("$$$$"+i);
			}
		};
		r1.run();
		r2.run();
	}
}
