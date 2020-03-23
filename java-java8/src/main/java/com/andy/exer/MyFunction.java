package com.andy.exer;

@FunctionalInterface
public interface MyFunction {
	
	public String getValue(String str);

	default String getValue2(String str){
		return null;
	}

}
