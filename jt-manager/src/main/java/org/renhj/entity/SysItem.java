package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysItem extends BaseEntity {

    private Long id;                // 商品ID
    private Long cid;              // 商品分类ID
    private String brand;          // 商品品牌
    private String model;          // 商品型号
    private String title;          // 商品标题
    private String sellPoint;     // 商品卖点信息
    private Long price;           // 商品价格
    private Integer num;          // 商品数量
    private String barcode;      // 条形码
    private String image;        // 商品图片信息
    private Integer status;     // 商品状态 1正常 2下架 3删除
}
