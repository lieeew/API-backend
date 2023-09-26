package com.yupi.yuapi.model.dto.interfaceInfo;


import java.io.Serializable;

/**
 * @author leikooo
 * @create 2023-09-22 16:24
 * @Package com.yupi.yuapi.model.dto.interfaceInfo
 * @Description 用户传递的参数
 */

public class InterfaceInfoInvokeRequest implements Serializable {
    private static final long serialVersionUID = 7805224567515210964L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 请求参数
     */
    private String userRequestParams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserRequestParams() {
        return userRequestParams;
    }

    public void setUserRequestParams(String userRequestParams) {
        this.userRequestParams = userRequestParams;
    }
}
