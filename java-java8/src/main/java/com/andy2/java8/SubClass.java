package com.andy2.java8;

import com.andy.java8.MyFun;

public class SubClass implements MyFun, MyInterface{

	@Override
	public String getName() {
		return MyInterface.super.getName();
	}

	@Override
	public Integer getValue(Integer num) {
		return null;
	}
}
