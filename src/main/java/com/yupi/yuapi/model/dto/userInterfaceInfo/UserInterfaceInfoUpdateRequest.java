package com.yupi.yuapi.model.dto.userInterfaceInfo;

import lombok.Data;
import java.io.Serializable;

/**
 * @author leikooo
 * @create 2023-09-22 16:24
 * @Package com.yupi.yuapi.model.dto.interfaceInfo
 * @Description 更新接口
 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {

    private static final long serialVersionUID = 3030629027377223666L;

    /**
     * 主键
     */
    private Long id;

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
