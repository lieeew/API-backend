package com.yupi.yuapi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuapicommen.model.entity.UserInterfaceInfo;
import com.yuapicommen.model.vo.UserInterfaceVO;

import java.util.List;

/**
* @author liang
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2023-09-26 20:39:07
* @Entity UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterface(int limit);
}




