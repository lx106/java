package com.example.test;

import java.lang.reflect.Field;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-06-01-15:21
 */
public class TestPerson {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Person p = new Person();
        Class<? extends Person> pClass = p.getClass();

        Field name = pClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(p));


        Integer key = 10000000;
        int h;
        h = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(h+":"+key.hashCode());
        System.out.println(  2147483647  >>> 16);
    }
}
