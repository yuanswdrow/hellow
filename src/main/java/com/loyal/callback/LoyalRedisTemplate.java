package com.loyal.callback;

import javax.annotation.Resource;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class LoyalRedisTemplate implements ILoyalRedisOperations {

    private JedisPool jedisPool; 
    public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
    public JedisPool getJedisPool() {
		return jedisPool;
	}
    
    @Override  
    public <T> T execute(ILoyalConnectionCallback<T> action) {  
        Jedis jedis = null;  
        try{  
            // 从连接池中获取jedis分片对象  
            jedis = jedisPool.getResource();  
              
            return action.doInRedis(jedis);  
              
        }catch (Exception e){  
            System.out.println(e.getMessage());  
        }finally {  
            if(null != jedis){  
            	jedis.close();  
            }  
        }  
        return null;  
    }  
      
   /** 
     * attention:真正封装的方法，非常的简洁干脆 
     */  
    public String set(final String key, final String value){  
        return execute(new ILoyalConnectionCallback<String>() {  
            @Override  
            public String doInRedis(Jedis jedis) {  
                return jedis.set(key, value);  
            }  
        });  
    }  
      
    public String get(final String key){  
        return execute(new ILoyalConnectionCallback<String>(){  
            @Override  
            public String doInRedis(Jedis jedis) {  
                return jedis.get(key);  
            }  
        });  
    }  


}
