package com.yupi.yuapi.model.dto.userInterfaceInfo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author leikooo
 * @create 2023-09-22 16:24
 * @Package com.yupi.yuapi.model.dto.interfaceInfo
 * @Description 查询接口
 */
@Data
public class UserInterfaceInfoQueryRequest implements Serializable {

    private static final long serialVersionUID = 2776701197761137416L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 接口 id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0-正常，1-禁用
     */
    private Integer status;

}

