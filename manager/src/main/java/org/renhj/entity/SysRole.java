package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRole extends BaseEntity {
    private static final long serialVersionUID = 6276276680024469140L;

    private Long id;
    private String role;  // admin
    private String note;  // 管理员

}
