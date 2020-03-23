package com.lx.java8;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-07-18-18:45
 */
public class TestInteger {

    public static void main(String[] args){

       Integer i = new Integer(1288);
       Integer j = new Integer(2888);
       swap(i,j);
        System.out.println(j);
        System.out.println(i);
    }

    public static void swap(Integer i,Integer j){
        Integer temp = new Integer(i);
        i = j;
        j= temp;
    }
}
