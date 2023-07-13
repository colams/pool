package cn.colams.common;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }

    public Boolean setIfAbsent(String key, Object value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.setIfAbsent(key, value);
    }

    public Object get(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    public Long ttl(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.getOperations().getExpire(key);
    }
}
