package org.renhj.entity;

import org.renhj.base.BaseEntity;

import java.io.Serializable;

public class SysOperation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -6733804092800020207L;

    public SysOperation(){
        super();
    }

    private Integer id;
    private String operation;   // 操作名称   删除
    private String name;         // 操作标志   delete
    private String note;         // 操作描述   删除操作

}
