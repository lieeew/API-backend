package com.yupi.yuapi.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author leikooo
 * @create 2023-09-22 16:24
 * @Package com.yupi.yuapi.model.dto.interfaceInfo
 * @Description
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    private static final long serialVersionUID = 461093235256819329L;

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

}
