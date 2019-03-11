package org.renhj.manager.pojo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_log")
public class TbLog {
    /**
     * 日志id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 事件名称
     */
    private String event;

    /**
     * 类名
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 参数列表
     */
    private String parameter;

    /**
     * 创建日期
     */
    private Date created;

    /**
     * 修改日期
     */
    private Date updated;

    /**
     * 获取日志id
     *
     * @return id - 日志id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置日志id
     *
     * @param id 日志id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取操作用户
     *
     * @return username - 操作用户
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作用户
     *
     * @param username 操作用户
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取事件名称
     *
     * @return event - 事件名称
     */
    public String getEvent() {
        return event;
    }

    /**
     * 设置事件名称
     *
     * @param event 事件名称
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * 获取类名
     *
     * @return class_name - 类名
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置类名
     *
     * @param className 类名
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取参数列表
     *
     * @return parameter - 参数列表
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * 设置参数列表
     *
     * @param parameter 参数列表
     */
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    /**
     * 获取创建日期
     *
     * @return created - 创建日期
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建日期
     *
     * @param created 创建日期
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取修改日期
     *
     * @return updated - 修改日期
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置修改日期
     *
     * @param updated 修改日期
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}