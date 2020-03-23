package com.lx.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-06-28-14:09
 */
public class Test {

    public static void main(String[] args){
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1],t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        String[] strings = new String[9];
        strings[0] = "andu";
        strings[0] = "andu";
        strings[0] = "andu";
        String collect = Arrays.stream(strings).collect(Collectors.joining(","));
        System.out.println(collect);
        Arrays.stream(strings).collect(Collectors.maxBy(String::compareTo));

        Integer[] integers = new Integer[6];
        Arrays.stream(integers).collect(Collectors.summingInt(x -> x));
    }
}
