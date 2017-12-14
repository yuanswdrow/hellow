package com.loyal.callback;

import redis.clients.jedis.Jedis;

public interface ILoyalConnectionCallback<T> {
	T doInRedis(Jedis jedis); 
}
