package org.renhj.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class SysLogs implements Serializable {
    private static final long serialVersionUID = 5247794220446826747L;

    private Integer id;
    // 用户名
    private String username;
    // 操作
    private String operation;
    // 执行方法
    private String method;
    // 执行参数
    private String params;
    // 执行时长（毫秒）
    private Long time;
    // ip
    private String ip;
    private Date createdTime;
}
