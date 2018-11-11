package org.renhj.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = -1272449917254099069L;

    private Integer id;
    private String username;
    private String createTime;
}
