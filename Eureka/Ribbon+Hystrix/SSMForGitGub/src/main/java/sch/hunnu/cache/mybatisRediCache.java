package sch.hunnu.cache;

import java.util.concurrent.locks.ReadWriteLock; 
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import sch.hunnu.utils.SerializeUtil;
import sch.hunnu.utils.redisUtil;

/**
 * 鐢ㄤ簬缁檓ybatis鍋氫簩绾х紦瀛�
 * @author Hi
 *
 */
public class mybatisRediCache implements Cache{
	
	
	
	private final static Logger logger = LoggerFactory.getLogger(mybatisRediCache.class);
			
	
	private Jedis  jedis= redisUtil.getJedis(); 
	
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private String id;
	
	/**
	 * 鏋勯�犲嚱鏁� 浼犲叆id
	 * @param id
	 */
	public mybatisRediCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id+"\n\n\n");
        this.id = id;
    }

	/**
	 * 杩斿洖id鍊�
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 灏嗙紦瀛� 浠ey-value鐨勫舰寮忚繘琛屽簭鍒楀寲鐒跺悗 鍐欏叆redis
	 */
	public void putObject(Object key, Object value) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>putObject:" + key + "=" + value+"\n\n\n");
        jedis.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
	}

	/**
	 * 鍏堝皢key杩涜搴忓垪鍖栵紝鏍规嵁杩欎釜搴忓垪鍖栧悗鐨刱ey 鍙栧緱redis涓寚瀹氱殑搴忓垪鍖栧悗鐨刡yte鍐呭鍙栧嚭 鐒跺悗杩涜鍙嶅簭鍒楀寲 鎴愪竴涓璞℃垨鑰呭��
	 */
	public Object getObject(Object key) {
		Object value = SerializeUtil.unserialize(jedis.get(SerializeUtil.serialize(key.toString())));
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>getObject:" + key + "=" + value+"\n\n\n");
        return value;
	}
	
	/**
	 *	 鍒犻櫎鎸囧畾鐨刱ey銆�value
	 */
	public Object removeObject(Object key) {
		  return jedis.del(SerializeUtil.serialize(key.toString()));
	}

	
	/**
	 * 鍒犲簱 璺戣矾
	 */
	public void clear() {
		jedis.flushDB();
		
	}

	/**
	 * 杩斿洖reids鏁版嵁搴撶殑澶у皬
	 */
	public int getSize() {
		  return Integer.valueOf(jedis.dbSize().toString());
	}

	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

}
