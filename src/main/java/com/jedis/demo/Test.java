package com.jedis.demo;

import com.jedis.demo.client.Clinet;
import redis.clients.jedis.Jedis;

/**
 * @author weiqisheng
 * @Title: Test
 * @ProjectName Jedis
 * @Description: TODO
 * @date 2021/3/2216:29
 */
public class Test {

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.set("weiqisheng","15k");
//        String value = jedis.get("weiqisheng");
//        System.out.println(value);
        Clinet clinet = new Clinet("127.0.0.1",6379);
        System.out.println(clinet.set("weiqisheng", "爱张裕华"));
        System.out.println(clinet.get("weiqisheng"));
    }
}
