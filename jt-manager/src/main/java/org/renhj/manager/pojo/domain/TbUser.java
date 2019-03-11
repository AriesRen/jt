package org.renhj.manager.pojo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * MD5加密
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 最后一次修改时间
     */
    private Date updated;

    /**
     * 用户状态 0 未激活 1 正常 2 锁定
     */
    private Byte status;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取MD5加密
     *
     * @return password - MD5加密
     */
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    /**
     * 设置MD5加密
     *
     * @param password MD5加密
     */
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取最后一次修改时间
     *
     * @return updated - 最后一次修改时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置最后一次修改时间
     *
     * @param updated 最后一次修改时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取用户状态 0 未激活 1 正常 2 锁定
     *
     * @return status - 用户状态 0 未激活 1 正常 2 锁定
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置用户状态 0 未激活 1 正常 2 锁定
     *
     * @param status 用户状态 0 未激活 1 正常 2 锁定
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}