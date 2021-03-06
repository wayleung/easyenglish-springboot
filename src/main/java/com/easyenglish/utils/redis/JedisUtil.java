package com.easyenglish.utils.redis;//package com.way.utils.redis;
//
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//import javax.annotation.Resource;
//import java.util.Set;
//
//@Component
//public class JedisUtil {
//
//    @Resource
//    private static JedisPool jedisPool;
//
//    //private Jedis getResource(){
//    private static Jedis getResource(){
//        return jedisPool.getResource();
//    }
//
//    public byte[] set(byte[] key, byte[] value) {
//        Jedis jedis =  getResource();
//        try {
//            jedis.set(key,value);
//            return value;
//        } finally {
//            jedis.close();
//        }
//    }
//
//    public void expire(byte[] key, int i) {
//        Jedis jedis =  getResource();
//        try {
//            jedis.expire(key,i);
//        } finally {
//            jedis.close();
//        }
//    }
//
//    public byte[] get(byte[] key) {
//        Jedis jedis =  getResource();
//        try {
//           return jedis.get(key);
//        } finally {
//            jedis.close();
//        }
//    }
//
//    public void del(byte[] key) {
//        Jedis jedis =  getResource();
//        try {
//            jedis.get(key);
//        } finally {
//            jedis.close();
//        }
//    }
//
//    /**
//     * 删除所有key
//     * @param key
//     */
//
//    public static void flushAll(byte[] key) {
//    	//删除当前数据库中的所有Key
//    	//flushdb
//    	//删除所有数据库中的key
//    	//flushall
//        Jedis jedis =  getResource();
//        try {
//            jedis.flushAll();
//        } finally {
//            jedis.close();
//        }
//    }
//
//
//    public Set<byte[]> keys(String shiro_session_prefix) {
//        Jedis jedis =  getResource();
//        try {
//            return jedis.keys((shiro_session_prefix+"*").getBytes());
//        } finally {
//            jedis.close();
//        }
//    }
//}
