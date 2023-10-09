package cn.colams.web;

import cn.colams.biz.business.BasicConfigBiz;
import cn.colams.model.entity.RedisConfigVo;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching  // 开启缓存
public class RedisConfig extends CachingConfigurerSupport {


    private BasicConfigBiz basicConfigBiz;

    public RedisConfig(BasicConfigBiz basicConfigBiz) {
        this.basicConfigBiz = basicConfigBiz;
    }

    @Bean
    public RedisConnectionFactory connectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(false);
        poolConfig.setTestWhileIdle(true);
        JedisClientConfiguration clientConfig = JedisClientConfiguration.builder()
                .usePooling().poolConfig(poolConfig).and().build();

        RedisConfigVo redisConfigVo = new RedisConfigVo();
        // 单点redis
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(redisConfigVo.getHost());
        redisConfig.setPort(redisConfigVo.getPort());
        redisConfig.setDatabase(0);
        redisConfig.setPassword(RedisPassword.of(redisConfigVo.getPassword()));
        return new JedisConnectionFactory(redisConfig, clientConfig);
    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);

        //更改在redis里面查看key编码问题
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setDefaultSerializer(redisSerializer);
//        redisTemplate.setKeySerializer(redisSerializer);
//        redisTemplate.setValueSerializer(redisSerializer);
//        redisTemplate.setHashKeySerializer(redisSerializer);
//        redisTemplate.setHashValueSerializer(redisSerializer);
//        redisTemplate.setStringSerializer(redisSerializer);
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(factory);

        //更改在redis里面查看key编码问题
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setDefaultSerializer(redisSerializer);
//        redisTemplate.setKeySerializer(redisSerializer);
//        redisTemplate.setValueSerializer(redisSerializer);
//        redisTemplate.setHashKeySerializer(redisSerializer);
//        redisTemplate.setHashValueSerializer(redisSerializer);
//        redisTemplate.setStringSerializer(redisSerializer);
        return redisTemplate;
    }

    private RedisConfigVo getRedisConfig() {
        RedisConfigVo redisConfigVo = new RedisConfigVo();
        return redisConfigVo;
    }
}
