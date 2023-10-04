package com.yupi.yuapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuapicommen.model.entity.InterfaceInfo;
import com.yupi.yuapi.mapper.InterfaceInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author leikooo
 * @create 2023-10-02 15:50
 * @Package com.yupi.yuapi.service.impl.inner
 * @Description
 */
@SpringBootTest
class InnerInterfaceInfoServiceImplTest {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;
    @Test
    void getHosts() {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("host");
        // 选择多个字段
        queryWrapper.select("name", "host");
        List<Map<String, Object>> maps = interfaceInfoMapper.selectMaps(queryWrapper);
        // Map<String, String> hashMap = new HashMap<>();
        // maps.forEach(map -> {
        //     Set<String> keySet = map.keySet();
        //     for (String key : keySet) {
        //         hashMap.put(key, (String) map.get(key));
        //     }
        // });
        Map<String, String> hashMap = maps.stream()
                .collect(Collectors.toMap(
                        map -> (String) map.get("name"),
                        map -> (String) map.get("host")
                ));
        System.out.println("hashMap = " + hashMap);
    }
}