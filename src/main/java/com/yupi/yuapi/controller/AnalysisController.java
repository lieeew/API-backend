package com.yupi.yuapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuapicommen.model.entity.InterfaceInfo;
import com.yuapicommen.model.entity.UserInterfaceInfo;
import com.yuapicommen.model.vo.UserInterfaceVO;
import com.yupi.yuapi.annotation.AuthCheck;
import com.yupi.yuapi.common.BaseResponse;
import com.yupi.yuapi.common.ResultUtils;
import com.yupi.yuapi.mapper.UserInterfaceInfoMapper;
import com.yupi.yuapi.service.InterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author leikooo
 * @create 2023-10-04 11:14
 * @Package com.yupi.yuapi.controller
 * @Description 分析控制器
 */
@RestController
@Slf4j
@RequestMapping("/analysis")
public class AnalysisController {
    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<List<UserInterfaceVO>> listTopInvokeInterface() {
        // 根据 userInterfaceInfo 进行分组查询，查询调用次数最多的 limit 个接口的 id 和 totalCount
        Map<Long, List<UserInterfaceInfo>> interfaceInfoObjMap = userInterfaceInfoMapper.listTopInvokeInterface(3).stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        // 根据前 limit 的 id 查询 interface 的全部数据
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceInfoObjMap.keySet());
        List<InterfaceInfo> interfaceInfos = interfaceInfoService.list(queryWrapper);
        List<UserInterfaceVO> userInterfaceVOList = interfaceInfos.stream().map(interfaceInfo -> {
            UserInterfaceVO userInterfaceVO = new UserInterfaceVO();
            BeanUtils.copyProperties(interfaceInfo, userInterfaceVO);
            // 统计的每一个接口的
            int totalNum = interfaceInfoObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            userInterfaceVO.setTotalNum(totalNum);
            return userInterfaceVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(userInterfaceVOList);
    }
}
