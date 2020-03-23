package com.example.java8;

import com.example.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestSearch   {
    
	List<Employee> emps = Arrays.asList(
			new Employee("AAA", 30, 800),
			new Employee("BBB", 27, 900),
			new Employee("CCC", 24, 900),
			new Employee("DDD", 23, 700));
	
	/**
	 * allMatch 是否匹配所有元素
	 * anyMatch 有一个就为True
	 * noneMatch 所有的都不匹配才为true
	 * findFirst 
	 * findAny
	 * count
	 * max
	 * min
	 */
	@Test
	public void test(){
		boolean flag = emps.stream().noneMatch(x -> x.getAge()==37);
		System.out.println(flag+"noneMatch：没有找到");
		Optional<Employee> option = emps.stream().filter(x -> x.getAge()==87).findFirst();
		if(option.isPresent()){
			System.out.println(option.get());	
		}else{
			System.out.println("没有");
		}
		Optional<Employee> option2 = emps.stream().findAny();
		System.out.println(option2.get());
		
		System.out.println(emps.stream().count());
		System.out.println(emps.stream().max((x,y)->-x.getAge()-y.getAge()));
		
		Optional<Integer> age = emps.stream().map(Employee::getAge).min(Integer::compareTo);
	    System.out.println(age.get());
	}
}
