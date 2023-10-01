package com.yupi.yuapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @author leikooo
 * @create 2023-09-27 13:12
 * @Package com.yupi.yuapi.service
 * @Description
 */
@SpringBootTest
class UserInterfaceInfoServiceTest {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Test
    void invokeCount() {
        boolean result = userInterfaceInfoService.invokeCount(1L, 1705209434684280834L);
        Assertions.assertTrue(result);
    }
}