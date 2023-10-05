package com.yupi.yuapi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yuapicommen.model.entity.UserInterfaceInfo;
import com.yupi.yuapi.model.dto.userInterfaceInfo.UserInterfaceInfoAddRequest;

import javax.servlet.http.HttpServletRequest;

/**
* @author liang
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-09-26 20:39:07
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 检验参数是否合法
     *
     * @param userInterfaceInfo
     * @param b
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean b);

    /**
     * 调用接口后需要执行的方法
     *
     * @param interfaceId 接口 id
     * @param userId      调用接口的用户 id
     * @return
     */
    boolean invokeCount(long interfaceId, long userId);

    /**
     * 添加表中的数据
     *
     * @param interfaceInfoId
     * @param totalCount
     * @param userId
     * @return 新增数据的 id
     */
    long addUserInterfaceInfoCount(long userId, long interfaceInfoId, int totalCount);
}
