package com.yupi.yuapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuapicommen.model.entity.InterfaceInfo;
import com.yuapicommen.service.InnerInterfaceInfoService;
import com.yupi.yuapi.mapper.InterfaceInfoMapper;
import org.apache.dubbo.config.annotation.DubboService;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author leikooo
 * @create 2023-10-01 21:57
 * @Package com.yupi.yuapi.service.impl
 * @Description 尽量不要引用同级别的方法 比如 service 引入 service
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String path, String host, String method) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("path", path);
        queryWrapper.eq("host", host);
        queryWrapper.eq("method", method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public Map<String, String> getHosts() {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("host");
        // 选择多个字段
        queryWrapper.select("name", "host");
        List<Map<String, Object>> maps = interfaceInfoMapper.selectMaps(queryWrapper);
        return maps.stream()
                .collect(Collectors.toMap(
                        map -> (String) map.get("name"),
                        map -> (String) map.get("host")
                ));
    }
}
