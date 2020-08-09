package com.lx;


import java.util.concurrent.locks.LockSupport;

class Solution {

    public static void main(String[] args) {
        LockSupport.park();
        test();
    }

    public static String test(){
        StringBuffer a = new StringBuffer(1000);
        a.append("asdfsdf");
        System.out.println(a);
        return "345";
    }
}