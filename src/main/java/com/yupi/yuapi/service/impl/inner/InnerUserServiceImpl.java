package com.yupi.yuapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuapicommen.model.entity.User;
import com.yuapicommen.service.InnerUserService;
import com.yupi.yuapi.mapper.InterfaceInfoMapper;
import com.yupi.yuapi.mapper.UserMapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author leikooo
 * @create 2023-10-01 21:57
 * @Package com.yupi.yuapi.service.impl
 * @Description
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过 accessKey secretKey 获取用户信息
     *
     * @param accessKey accessKey
     * @return
     */
    @Override
    public User getInvokeUser(String accessKey) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
