package org.renhj.manager.pojo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_address")
public class TbAddress {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 是否默认地址
     */
    @Column(name = "Is_default")
    private Byte isDefault;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 状态码
     */
    private Byte status;

    /**
     * 姓名
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 固定电话
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /**
     * 移动电话
     */
    @Column(name = "receiver_mobile")
    private String receiverMobile;

    /**
     * 省
     */
    @Column(name = "receiver_state")
    private String receiverState;

    /**
     * 市
     */
    @Column(name = "receiver_city")
    private String receiverCity;

    /**
     * 区县
     */
    @Column(name = "receiver_district")
    private String receiverDistrict;

    /**
     * 地址门牌
     */
    @Column(name = "receiver_address")
    private String receiverAddress;

    /**
     * 邮编
     */
    @Column(name = "receiver_zip")
    private String receiverZip;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改时间
     */
    private Date updated;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取是否默认地址
     *
     * @return Is_default - 是否默认地址
     */
    public Byte getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否默认地址
     *
     * @param isDefault 是否默认地址
     */
    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取状态码
     *
     * @return status - 状态码
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态码
     *
     * @param status 状态码
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取姓名
     *
     * @return receiver_name - 姓名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置姓名
     *
     * @param receiverName 姓名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取固定电话
     *
     * @return receiver_phone - 固定电话
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * 设置固定电话
     *
     * @param receiverPhone 固定电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取移动电话
     *
     * @return receiver_mobile - 移动电话
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * 设置移动电话
     *
     * @param receiverMobile 移动电话
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    /**
     * 获取省
     *
     * @return receiver_state - 省
     */
    public String getReceiverState() {
        return receiverState;
    }

    /**
     * 设置省
     *
     * @param receiverState 省
     */
    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    /**
     * 获取市
     *
     * @return receiver_city - 市
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     * 设置市
     *
     * @param receiverCity 市
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * 获取区县
     *
     * @return receiver_district - 区县
     */
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    /**
     * 设置区县
     *
     * @param receiverDistrict 区县
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    /**
     * 获取地址门牌
     *
     * @return receiver_address - 地址门牌
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * 设置地址门牌
     *
     * @param receiverAddress 地址门牌
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * 获取邮编
     *
     * @return receiver_zip - 邮编
     */
    public String getReceiverZip() {
        return receiverZip;
    }

    /**
     * 设置邮编
     *
     * @param receiverZip 邮编
     */
    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
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
     * 获取修改时间
     *
     * @return updated - 修改时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置修改时间
     *
     * @param updated 修改时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}