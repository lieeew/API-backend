package com.yupi.yuapi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yuapicommen.model.entity.InterfaceInfo;

/**
* @author liang
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-09-22 16:15:30
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 校验性别
     *
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
