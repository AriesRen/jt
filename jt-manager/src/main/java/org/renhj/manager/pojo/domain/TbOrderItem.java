package org.renhj.manager.pojo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_order_item")
public class TbOrderItem {
    /**
     * 商品id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 商品购买数量
     */
    private Integer num;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品单价
     */
    private Long price;

    /**
     * 商品总金额
     */
    @Column(name = "total_fee")
    private Long totalFee;

    /**
     * 商品图片地址
     */
    @Column(name = "pic_path")
    private String picPath;

    private Date created;

    private Date updated;

    /**
     * 获取商品id
     *
     * @return item_id - 商品id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置商品id
     *
     * @param itemId 商品id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取商品购买数量
     *
     * @return num - 商品购买数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置商品购买数量
     *
     * @param num 商品购买数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取商品标题
     *
     * @return title - 商品标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置商品标题
     *
     * @param title 商品标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取商品单价
     *
     * @return price - 商品单价
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置商品单价
     *
     * @param price 商品单价
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取商品总金额
     *
     * @return total_fee - 商品总金额
     */
    public Long getTotalFee() {
        return totalFee;
    }

    /**
     * 设置商品总金额
     *
     * @param totalFee 商品总金额
     */
    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 获取商品图片地址
     *
     * @return pic_path - 商品图片地址
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * 设置商品图片地址
     *
     * @param picPath 商品图片地址
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    /**
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}