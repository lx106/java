package com.example.java8;

import com.example.bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 *   Stream 的操作步骤
 *  1 创建流
 *  2 中间操作
 *  3 终止操作
 *
 *  //3. 终止操作
	 /*
	 allMatch——检查是否匹配所有元素
	 anyMatch——检查是否至少匹配一个元素
	 noneMatch——检查是否没有匹配的元素
	 findFirst——返回第一个元素
	 findAny——返回当前流中的任意元素
	 count——返回流中元素的总个数
	 max——返回流中最大值
	 min——返回流中最小值
	 注意：流进行了终止操作后，不能再次使用
 */

public class TestStreamAPI1 {

	@Test
	public void test1(){
		// 第一种方式  通过Collection 集合提供的 stream() 方法
		List<Employee> emps = new ArrayList<>();
		Stream<Employee> s1 = emps.stream();
		// 第二种 通过Arrays的静态方法stream()
		Employee[] emps2 = new Employee[10];
		Stream<Employee> s2 = Arrays.stream(emps2);
		// 第三种 通过 
		Stream<Employee> s3 = Stream.of(new Employee(),new Employee());
		// 第四种 创建无限流 迭代
		int x =10;
		Stream<Integer> s4 = Stream.iterate(x, (y) -> y +2);
				s4.limit(0)
				  .forEach(System.out::println);
		// 生成
		Stream.generate(Math::random).limit(100)
		      .forEach(System.out::println) ; 	
		
	}
	List<Employee> emps = Arrays.asList(new Employee("AAA", 30, 8000),
			new Employee("maozhi", 27, 9000),
			new Employee("liuxun", 24, 9000),
			new Employee("ww", 23, 7000));
	@Test
	public void test2(){ //中间操作不会执行任何操作  只有终止操作才会一次执行 所有中间操作  这叫做 延迟求值
		emps.stream().filter((x) -> x.getAge()==23)
		.limit(2) // limit 为短路操作
		.distinct()
		.forEach(System.out::println);
	}
}
