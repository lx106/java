package com.lx.java8;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-07-13-10:06
 */
public class TestArrayList {

    public static void main(String[] args) throws Exception {

        /*ArrayList<Integer> list = new ArrayList<>(10);
        list.add(1);
        System.out.println(list.size());

        Class<?> clazz = Class.forName("java.util.ArrayList");
        Field elementData = clazz.getField("elementData");
        System.out.println(elementData);*/



        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(2);
        list1.add(2);
        list1.add(2);
        list1.add(2);

        Integer reduce = list1.stream().reduce(1, (x, y) -> y = x * y);
        System.out.println(reduce);

    }
}
