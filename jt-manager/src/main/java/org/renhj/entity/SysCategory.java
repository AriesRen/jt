package org.renhj.entity;

import org.renhj.base.BaseEntity;

public class SysCategory extends BaseEntity {

    private Long id;          // 分类ID
    private String category; // 分类名称
    private String parentId; // 父ID
}
