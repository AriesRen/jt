package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysCategory extends BaseEntity {
    private static final long serialVersionUID = -8414694211198890231L;
    private Long id;          // 分类ID
    private String category; // 分类名
    private String note;     //  分类描述
    private String parentId; // 父ID
}
