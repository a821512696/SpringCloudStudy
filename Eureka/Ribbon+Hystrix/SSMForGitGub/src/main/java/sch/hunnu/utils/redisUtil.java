package sch.hunnu.utils;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class redisUtil {

	
	
	/**
	 * 
	 * 从jedis.properties 中获取redis的主机信息
	 * jedis pool 获取jedis连接
	 * @return
	 */
	public static Jedis getJedis(){
	//	System.out.println(host+"  "+port);
		//JedisPoolConfig config = new JedisPoolConfig();
		
		ResourceBundle rb =ResourceBundle.getBundle("config/redis");
		JedisPool jp = new JedisPool(rb.getString("redis.host"), Integer.parseInt(rb.getString("redis.port")));
		System.out.println(rb.getString("redis.host")+"  "+rb.getString("redis.port"));
	
		return jp.getResource();
	}
}
