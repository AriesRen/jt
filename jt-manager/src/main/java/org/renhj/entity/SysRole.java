package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6276276680024469140L;

    public SysRole(){
        super();
    }

    private Integer id;
    private String role;  // admin
    private String note;  // 管理员

}
