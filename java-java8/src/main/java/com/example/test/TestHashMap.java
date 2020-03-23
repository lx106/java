package com.example.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class TestHashMap {

	public static void main(String[] args) throws Exception {
        HashMap<Person, Object> map = new HashMap<>(100);
        System.err.println(map.size());

            for (int i = 0; i < 200; i++) {
                map.put(new Person(),i);
            }

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));


        Field threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold : " + threshold.get(map));
    }
  
}