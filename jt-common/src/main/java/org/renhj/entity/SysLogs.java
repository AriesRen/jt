package org.renhj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreatedTime(){
        return this.createdTime;
    }
}
