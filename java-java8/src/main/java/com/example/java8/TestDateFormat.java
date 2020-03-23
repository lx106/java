package com.example.java8;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDateFormat {

	@Test
	public void test(){
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		LocalDateTime ldt = LocalDateTime.now();
		String str = ldt.format(dtf);
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(str);
		System.out.println(LocalDateTime.now());
		System.out.println(ldt.format(dtf));
	}
}
