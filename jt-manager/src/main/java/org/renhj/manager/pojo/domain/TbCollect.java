package org.renhj.manager.pojo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_collect")
public class TbCollect {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 商品id
     */
    @Column(name = "item_id")
    private Long itemId;

    /**
     * 商品名称
     */
    @Column(name = "item_title")
    private String itemTitle;

    /**
     * 商品价格
     */
    @Column(name = "item_price")
    private Long itemPrice;

    /**
     * 商品图片
     */
    @Column(name = "item_image")
    private String itemImage;

    /**
     * 商品参数
     */
    @Column(name = "item_param_data")
    private String itemParamData;

    /**
     * 状态码
     */
    private Byte status;

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
     * 获取商品id
     *
     * @return item_id - 商品id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置商品id
     *
     * @param itemId 商品id
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取商品名称
     *
     * @return item_title - 商品名称
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * 设置商品名称
     *
     * @param itemTitle 商品名称
     */
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    /**
     * 获取商品价格
     *
     * @return item_price - 商品价格
     */
    public Long getItemPrice() {
        return itemPrice;
    }

    /**
     * 设置商品价格
     *
     * @param itemPrice 商品价格
     */
    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * 获取商品图片
     *
     * @return item_image - 商品图片
     */
    public String getItemImage() {
        return itemImage;
    }

    /**
     * 设置商品图片
     *
     * @param itemImage 商品图片
     */
    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    /**
     * 获取商品参数
     *
     * @return item_param_data - 商品参数
     */
    public String getItemParamData() {
        return itemParamData;
    }

    /**
     * 设置商品参数
     *
     * @param itemParamData 商品参数
     */
    public void setItemParamData(String itemParamData) {
        this.itemParamData = itemParamData;
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