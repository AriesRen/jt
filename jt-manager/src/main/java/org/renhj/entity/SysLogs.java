package org.renhj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysLogs extends BaseEntity implements Serializable{
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

}
