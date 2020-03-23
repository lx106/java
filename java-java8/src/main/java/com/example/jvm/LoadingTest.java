package com.example.jvm;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-05-17-13:55
 * before先打印是因为类中有静态属性 loadingTest 并 使用 new
 * after2 打印 value2 = 0 因为此静态属性最后初始化
 */
public class LoadingTest {

    private static LoadingTest loadingTest = new LoadingTest();
    private static int value1;
    private static int value2 = 0;

    public LoadingTest() {
        value1 = 10;
        value2 = value1;
        System.out.println("before1："+value1);
        System.out.println("before2："+value2);
    }

    public static void main(String[] args){
        System.out.println("after1："+value1);
        System.out.println("after2："+value2);
    }
}
