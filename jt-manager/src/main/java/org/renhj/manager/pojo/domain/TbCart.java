package org.renhj.manager.pojo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_cart")
public class TbCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_title")
    private String itemTitle;

    @Column(name = "item_image")
    private String itemImage;

    /**
     * 单位：分
     */
    @Column(name = "item_price")
    private Long itemPrice;

    private Integer num;

    private Date created;

    private Date updated;

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
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return item_id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return item_title
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * @param itemTitle
     */
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    /**
     * @return item_image
     */
    public String getItemImage() {
        return itemImage;
    }

    /**
     * @param itemImage
     */
    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    /**
     * 获取单位：分
     *
     * @return item_price - 单位：分
     */
    public Long getItemPrice() {
        return itemPrice;
    }

    /**
     * 设置单位：分
     *
     * @param itemPrice 单位：分
     */
    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
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