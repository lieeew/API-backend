package com.yupi.yuapi.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leikooo
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonConfig {

    /**
     * 端口
     */
    private String port;

    /**
     * 主机
     */
    private String host;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * redisson 需要的 redis 库
     */
    private String database;

    @Bean
    public RedissonClient redissonClient() {
        // 1. Create config object
        Config config = new Config();
        // 这里不要写死
        // String redissonUrl = String.format("redis://%s:%s@%s:%s", username, password, host, port);
        String redissonUrl = String.format("redis://%s:%s", host, port);
        config.useSingleServer().setAddress(redissonUrl).setDatabase(Integer.parseInt(database));

        // 2. Create Redisson instance
        // Sync and Async API
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

}
