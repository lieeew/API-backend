package com.yupi.yuapi.utils;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author leikooo
 * @create 2023-09-24 12:35
 * @Package com.yupi.yuapi.utils
 * @Description
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedissonClient redissonClient;

    @Test
    void testRedisIsAvailability() {
        RList<Object> rList = redissonClient.getList("test:list");
        rList.set(0, "哈哈");
        Object instance = rList.get(0);
        System.out.println("instance = " + instance);
        // 设置列表的过期时间为60分
        rList.expire(60, TimeUnit.MINUTES);
    }
}
