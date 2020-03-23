package com.lx.java8;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-07-02-15:52
 */
public class TestInfiniteFlow {

    public static void main(String[] args){

        Stream.generate(Math::random).limit(5).forEach(System.out::print);

        List<Integer> collect = Stream.iterate(0,i -> i + 1).limit(5).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1],t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::print);

    }
}
