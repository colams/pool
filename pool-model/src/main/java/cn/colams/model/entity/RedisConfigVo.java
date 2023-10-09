package cn.colams.model.entity;

public class RedisConfigVo {

    /*
    * # Redis 库的编号
        spring.redis.database=0
        # Redis 实例地址
        spring.redis.host=redis-10541.c290.ap-northeast-1-2.ec2.cloud.redislabs.com
        # Redis 实例端口号，默认6379
        spring.redis.port=10541
        # Redis 登录账户
        spring.redis.username=default
        spring.redis.password=nz5cWOeZQFKndRNyAMDb5C7Z1I7t3dnw
        # Redis 登录密码
        spring.redis.auth=nz5cWOeZQFKndRNyAMDb5C7Z1I7t3dnw # spring.redis.password=123456
        # Redis 连接池最大连接数
        spring.redis.jedis.pool.max-active=10
        # Redis 连接池最大空闲连接数
        spring.redis.jedis.pool.max-idle=10
        # Redis 连接池最小空闲连接数
        spring.redis.jedis.pool.min-idle=0
    * */

    private String host;
    private int port;
    private String username;
    private String password;

    public RedisConfigVo() {
        this.host = "redis-10541.c290.ap-northeast-1-2.ec2.cloud.redislabs.com";
        this.port = 10541;
        this.username = "default";
        this.password = "nz5cWOeZQFKndRNyAMDb5C7Z1I7t3dnw";
    }

    public RedisConfigVo(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
