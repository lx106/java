package com.example.java8;

@FunctionalInterface
public interface MyFun<T> {

	public T getValue(T t);
}
