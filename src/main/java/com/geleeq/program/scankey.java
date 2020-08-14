package com.geleeq.program;

import com.geleeq.pubsub.Publisher;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

public class scankey {
    public static void main(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        JedisPool jedisPool = new JedisPool(poolConfig, "localhost", 6379, 3000);

        Jedis publisherJedis = jedisPool.getResource();
        //发布，循环读取输入流，quit停止
        new Publisher(publisherJedis).start1();
        List<String> aa = new Publisher(publisherJedis).scanAll("0","*",50);
        System.out.println(aa);
        System.out.println(aa.size());
    }


}
