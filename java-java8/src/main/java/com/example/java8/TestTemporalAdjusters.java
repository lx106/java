package com.example.java8;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TestTemporalAdjusters {

	@Test
	public void test(){
		
		LocalDateTime ldt = LocalDateTime.now();
		
		LocalDateTime ldt2 = ldt.withDayOfMonth(3);
		
		System.out.println(ldt);
		System.out.println(ldt2);
		
		LocalDateTime ldt3 =ldt.with(TemporalAdjusters.lastDayOfMonth());
		LocalDateTime ldt4 = ldt3.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println(ldt4);
		
		ldt4.with((x) -> {
			LocalDateTime t = (LocalDateTime) x;
			return t.plusDays(20);
		});
	}
}
