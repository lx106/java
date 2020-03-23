package com.lx.java8;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-07-02-14:51
 */
public class TestPerformance2 {

    public static void main(String[] args){

        Instant instant = Instant.now();

        Long reduce = Stream.iterate(1L, i -> i + 1).limit(1000000000L).reduce(0L, Long::sum);

        Instant instant1 = Instant.now();

        Long reduce2 = Stream.iterate(1L, i -> i + 1).limit(10000000L).reduce(0L, Long::sum);

        Instant instant2 = Instant.now();

        System.out.println(Duration.between(instant,instant1).getNano());
        System.out.println(Duration.between(instant1,instant2).getNano());
    }
}
