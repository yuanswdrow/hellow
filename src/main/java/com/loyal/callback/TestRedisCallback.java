package com.loyal.callback;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestRedisCallback {
    
	@Test
	public void gogo() {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-redis.xml");

		//JedisPoolConfig jedisPoolConfig=(JedisPoolConfig)context.getBean("poolConfig2");
		JedisPool jedisPool = (JedisPool) context.getBean("jedisPool");

		LoyalRedisTemplate redisTemplate = new LoyalRedisTemplate();
		redisTemplate.setJedisPool(jedisPool);

		// =====================testString======================
		redisTemplate.set("address", "众诚品业");
		redisTemplate.set("age", "北京BeiJing");

		System.out.println(redisTemplate.get("address"));

		System.out.println(redisTemplate.get("age"));


	}

}
