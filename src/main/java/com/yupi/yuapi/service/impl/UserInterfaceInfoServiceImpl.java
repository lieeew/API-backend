package com.yupi.yuapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.yuapi.common.ErrorCode;
import com.yupi.yuapi.exception.BusinessException;
import com.yupi.yuapi.mapper.UserInterfaceInfoMapper;
import com.yupi.yuapi.model.entity.UserInterfaceInfo;
import com.yupi.yuapi.service.UserInterfaceInfoService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author leikooo
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
 * @createDate 2023-09-26 20:39:07
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Resource
    private RedissonClient redissonClient;

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean b) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (b) {
            // 创建时，所有参数必须非空
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口调用剩余次数不足");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean invokeCount(long interfaceId, long userId) {
        if (interfaceId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
        }
        RLock lock = redissonClient.getLock("yuapi:userInterfaceService:invokeCount");
        try {
           while (true) {
               if (lock.tryLock(0, -1, TimeUnit.MICROSECONDS)) {
                   UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
                   updateWrapper.eq("interfaceInfoId", interfaceId);
                   updateWrapper.eq("userId", userId);
                   updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
                   return this.update(updateWrapper);
               }
           }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        return false;
    }
}




