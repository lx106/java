package com.example.java8;

import com.example.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test10  {

	List<Employee> emps = Arrays.asList(new Employee("AAA", 30, 800),
			new Employee("andy", 27, 1000),
			new Employee("liuxun", 24, 600),
			new Employee("ww", 23, 500));

	@Test
	public void test2(){
		Optional<Integer> sum = emps.stream().map(x -> x.getAge()).reduce((x,y) -> x+=y);
		System.out.println(sum.get());
	}

	
	@Test
	public void test(){
	  List<Integer> list = Arrays.asList(1,2,3,4,5,6);
	  List<Integer> list2 = list.stream().map(x -> x*x).collect(Collectors.toList());
	  list2.forEach(System.out::println);
	  
	  Integer[] ints = new Integer[]{1,2,3,4,5};
	  Integer[] ints1 = new Integer[]{};
	  Integer[] ints2 = Arrays.asList(ints).stream().map(x -> x*x).collect(Collectors.toList()).toArray(ints1);

	  Arrays.stream(ints2).forEach(System.out::println);
	  Arrays.stream(ints).map(x -> x*x).forEach(System.out::println);
	  
	  
	}
}
