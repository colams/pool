package cn.colams.web;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching  // 开启缓存
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(300);
        return cacheManager;
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
}
