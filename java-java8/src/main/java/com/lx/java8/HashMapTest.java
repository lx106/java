package com.lx.java8;

import com.example.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-08-08-12:33
 */
public class HashMapTest {

    public static void main(String[] args){
        User user = new User();
        user.setName("i2d");
        user.setId(1);

        User user2 = new User();
        user2.setName("id");
        user2.setId(1);

        Map<User,User> map = new HashMap<>();
        map.put(user,user);

        map.put(user2,user2);

        System.out.println(map.size());


    }
}
