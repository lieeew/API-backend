package com.yupi.yuapi.common;


import java.io.Serializable;

/**
 * @author leikooo
 * @create 2023-09-25 18:05
 * @Package com.yupi.yuapi.common
 * @Description
 */
public class IdRequest implements Serializable {

    private static final long serialVersionUID = -3545110256908108729L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
