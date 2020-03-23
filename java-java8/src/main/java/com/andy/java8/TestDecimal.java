package com.andy.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-06-13-21:22
 */
public class TestDecimal {
    public static void main(String[] args){

        BigDecimal a = new BigDecimal(30);
        BigDecimal b = new BigDecimal(10);
        //BigDecimal c = b.divide(a).setScale(4,BigDecimal.ROUND_HALF_UP);
        BigDecimal d =null;
        d = b.divide(a,2,BigDecimal.ROUND_DOWN);
        System.out.println(d);


        List<String> list1 = new ArrayList<>();
        list1.add("liuxun3");
        list1.add("liuxun2");
        List<String> list2 = new ArrayList<>();
        list2.add("liuxun");
        list2.add("andy");
        list2.retainAll(list1);
        System.out.println(list2);


    }
}
