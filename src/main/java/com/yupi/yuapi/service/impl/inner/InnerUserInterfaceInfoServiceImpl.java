package com.yupi.yuapi.service.impl.inner;

import com.yuapicommen.service.InnerUserInterfaceInfoService;
import com.yupi.yuapi.service.InterfaceInfoService;
import com.yupi.yuapi.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author leikooo
 * @create 2023-10-01 21:57
 * @Package com.yupi.yuapi.service.impl
 * @Description
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
