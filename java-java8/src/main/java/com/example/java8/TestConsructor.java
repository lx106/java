package com.example.java8;

import com.example.bean.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 
 * @author liuxun
 */
public class TestConsructor {

	@Test //
	public void test6(){
		Function<Integer, String[]> fun = (x) -> new String[x];
		Function<Integer, String[]> fun1 = String[]::new;
	}
	
	@Test  //
	public void test5(){
		Supplier<Employee> sup = () -> new Employee();
		Supplier<Employee> sup1 = Employee::new;
	}
	
	
	@Test
	public void test(){
		PrintStream ps = System.out;
		Consumer<Integer> con = (x) -> System.out.println(x);
		Consumer<Integer> con1 = System.out::println;
		con1.accept(1);
	}
	
	@Test //
	public void test2(){
		Supplier<Double> sup = Math::random;
		System.out.println(sup.get());
		Employee e = new Employee("andy", 24, 10000);
		Supplier<String> sup1 = e::getName;
		System.out.println(sup1.get());
	}
	@Test //
	public void test3(){
		Comparator<String> cp = String::compareTo;
		int compare = cp.compare("BBB", "AAA");
		int compare2 = cp.compare("AAA", "CCC");
		System.out.println(compare+":"+compare2);
	}
	@Test //
	public void test4(){
		BiPredicate<Integer,Integer> bp = Integer::equals;
		boolean test = bp.test(2, 3);
		System.out.println(test);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
