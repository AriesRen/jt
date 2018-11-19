package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermission extends BaseEntity {
    private static final long serialVersionUID = -3574135278060445002L;

    private Integer id;
    private String permission;
    private String note;
}
