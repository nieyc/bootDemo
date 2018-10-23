package com.github.nyc.bootDemo.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration
public class JedisClusterConfig {

	@Autowired
    private RedisProperties redisProperties;
	
 
    /**
     * 注意：
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
     * @return
     */
    @Bean
    public JedisCluster getJedisCluster() {
        String[] serverArray = redisProperties.getClusterNodes().split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
        Set<HostAndPort> nodes = new HashSet<>();
 
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(redisProperties.getMaxActive());
        config.setMaxIdle(redisProperties.getMaxIdle());
        config.setMinIdle(redisProperties.getMinIdle());//设置最小空闲数
        config.setMaxWaitMillis(redisProperties.getMaxWait());
	    //在获取Jedis连接时，自动检验连接是否可用
	    config.setTestOnBorrow(true);
		//在将连接放回池中前，自动检验连接是否有效
		config.setTestOnReturn(true);
		//自动测试池中的空闲连接是否都是可用连接
		config.setTestWhileIdle(true);
		//连接耗尽时是否阻塞, false报异常,ture阻塞直到超时,默认true
		config.setBlockWhenExhausted(false);
        //表示idle object evitor两次扫描之间要sleep的毫秒数
        config.setTimeBetweenEvictionRunsMillis(30000);
        //表示idle object evitor每次扫描的最多的对象数
        config.setNumTestsPerEvictionRun(10);
        //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
        config.setMinEvictableIdleTimeMillis(60000);

        return new JedisCluster(nodes,redisProperties.getCommandTimeout(),1000,1,config);
        //return new JedisCluster(nodes,redisProperties.getCommandTimeout(),1000,1,new GenericObjectPoolConfig());//不需要密码连接的创建对象方式
    }
}
