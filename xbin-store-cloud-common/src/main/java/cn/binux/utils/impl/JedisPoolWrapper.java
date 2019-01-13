package cn.binux.utils.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

@Component
public class JedisPoolWrapper {

    private JedisPool jedisPool=null;

    @Autowired
    private RedisParameter parameters;

    @PostConstruct              /**这个注解保证这个方法一定会执行，其实也可以在构造方法中调用这个方法，不过用注解比较帅*/
    public void init() throws Exception{
        try {
            JedisPoolConfig config=new JedisPoolConfig();
            jedisPool=new JedisPool(config,parameters.getRedisHost(),parameters.getRedisPort(),3000);
        } catch (Exception e) {
            throw new Exception("初始化redis失败");
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

}
