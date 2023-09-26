package com.yupi.yuapi.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户调用接口关系
 * @TableName user_interface_info
 */
@TableName(value ="user_interface_info")
public class UserInterfaceInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 调用用户 id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 调用用户 id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 接口 id
     */
    public Long getInterfaceInfoId() {
        return interfaceInfoId;
    }

    /**
     * 接口 id
     */
    public void setInterfaceInfoId(Long interfaceInfoId) {
        this.interfaceInfoId = interfaceInfoId;
    }

    /**
     * 总调用次数
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * 总调用次数
     */
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * 剩余调用次数
     */
    public Integer getLeftNum() {
        return leftNum;
    }

    /**
     * 剩余调用次数
     */
    public void setLeftNum(Integer leftNum) {
        this.leftNum = leftNum;
    }

    /**
     * 0-正常，1-禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 0-正常，1-禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否删除(0-未删, 1-已删)
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除(0-未删, 1-已删)
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}