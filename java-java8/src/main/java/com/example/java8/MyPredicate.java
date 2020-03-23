package com.example.java8;


@FunctionalInterface
public interface MyPredicate<Employee> {

	public boolean test(Employee e);
}
