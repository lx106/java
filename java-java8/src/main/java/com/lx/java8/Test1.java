package com.lx.java8;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-08-08-19:06
 */
public class Test1 {

    public static void main(String[] args){
        StringBuilder s1 = new StringBuilder("a");
        StringBuilder s2 = new StringBuilder("b");

        copy(s1,s2);
        System.out.println(s1);
        System.out.println(s2);

        String s3 = new String("A");
        String s4 = "B";
        copy(s3,s4);
        System.out.println(s3);

        Integer i = 100;
        Integer j = new Integer(300);
        copy(i,j);
        System.out.println(i+j);
    }
    static void copy(StringBuilder s1,StringBuilder s2){
        s1 = s1.append("123");
        s2 = s2.append("123");
    }
    static void copy(String s1,String s2){
        s1 = "123";
        s2 = "345";
    }

    static void copy(Integer s1,Integer s2){
       s1 = 20;
       s2 = 30;
    }

}
