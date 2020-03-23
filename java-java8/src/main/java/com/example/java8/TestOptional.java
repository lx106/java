package com.example.java8;

import com.example.bean.Employee;
import com.example.bean.User;
import org.junit.Test;

import java.util.Optional;

/**
 * 
 * @author liuxun
 * 
 */
public class TestOptional {

	@Test
	public void test(){
		// 减少判断条件的例子
		//User user = null;
		User user = new User();
		user.setEmployee(new Employee("andy", 23, 10000));
		String name = Optional.ofNullable(user).map(x -> x.getEmployee()).map(y -> y.getName()).orElse("空");
		System.out.println(name);

	}
}
