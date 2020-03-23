package com.lx.java8;

import com.example.bean.Employee;
import com.example.bean.User;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created with liuxun
 * Description: 测试性能
 * Date: 2018-06-27-17:33
 */
public class TestPerformance {

    public static void main(String[] args){
        int count = 1000000;
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Employee(i+"",i,Math.random()));
        }

        Map<String,List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getName));

        List<Employee> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        Instant start = Instant.now();
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(),o2.getSalary());
            }
        });
        Employee e = null;
        for (int i = 0; i < count; i++) {
            e = list.get(i);
            if(e.getSalary()>0.5d){
                list2.add(e);
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            list3.add(list2.get(i).getName());
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).getNano());




        Instant start2 = Instant.now();
        List<String> collect = list.stream()
                .sorted((x, y) -> Double.compare(x.getSalary(), y.getSalary()))
                .filter((x) -> x.getSalary() > 0.5d)
                .map((x) -> x.getName())
                .collect(Collectors.toList());

        Instant end2 = Instant.now();
        System.out.println(Duration.between(start2,end2).getNano());


        Instant start3 = Instant.now();
        List<String> collect1 = list.parallelStream()
                .sorted((x, y) -> Double.compare(x.getSalary(), y.getSalary()))
                .filter((x) -> x.getSalary() > 0.5d)
                .map((x) -> x.getName())
                .collect(Collectors.toList());


        Instant end3 = Instant.now();
        System.out.println(Duration.between(start3,end3).getNano());

        System.out.println(System.nanoTime());
    }
}
