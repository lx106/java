package com.example.java8;

import com.example.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

	List<Employee> emps = Arrays.asList(new Employee("AAA", 30, 8000),
										new Employee("EEE", 37, 9000),
										new Employee("DDD", 37, 9000),
										new Employee("CCC", 28, 9000),
										new Employee("CCC", 24, 9000),
										new Employee("BBB", 23, 7000));
	@Test
	public void test1(){
	
		Collections.sort(emps,(x,y) -> {
			if(x.getAge() > y.getAge()){
				return 1;
			}else if(x.getAge() <y.getAge()){
				return 0;
			}else{
				return x.getName().compareTo(y.getName()) >1?1:0;
			}
		});
	
		 for (Employee employee : emps) {
			System.out.println(employee);
		 }
	}
	
}
