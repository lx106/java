package com.liuxun;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.liuxun.bean.Employee;
import org.junit.Test;

/**
 * 
 * @author liuxun
 * ��������   �����Ҫʵ�ֵ�Lamba���еķ����������Ѿ��еķ��� ������ͬ
 * ��������� �Ѿ�ʵ�ֵķ���
 * ��������ֵ���� �Լ���������Ҫһ��
 * �����﷨��ʽ
 * ���󣺣� ʵ��������
 * �ࣺ�� ��̬������
 * �ࣺ��ʵ��������
 * ������ ����
 * ��������
 *
 */
public class TestConsructor {

	@Test // ��������
	public void test6(){
		Function<Integer, String[]> fun = (x) -> new String[x];
		Function<Integer, String[]> fun1 = String[]::new;
	}
	
	@Test  //����������  Constructor::new
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
	
	@Test // ���󣺣�ʵ��������
	public void test2(){
		Supplier<Double> sup = Math::random;
		System.out.println(sup.get());
		
		Employee e = new Employee("liuze", 24, 10000);
		Supplier<String> sup1 = e::getName;
		
		System.out.println(sup1.get());
	}
	@Test // �� ������̬������
	public void test3(){
		
		Comparator<String> cp = String::compareTo;
	}
	@Test // �ࣺ��ʵ�������� ���ַ�ʽ����Լ����
	public void test4(){
		BiPredicate<Integer, Integer> bp = Integer::equals;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
