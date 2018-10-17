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
	 * ��jedis.properties �л�ȡredis��������Ϣ
	 * jedis pool ��ȡjedis����
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
