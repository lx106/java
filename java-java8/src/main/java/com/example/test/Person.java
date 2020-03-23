package com.example.test;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-06-01-15:20
 */
public class Person {
    private int id = 12;
    private String name = "liuxun";

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
