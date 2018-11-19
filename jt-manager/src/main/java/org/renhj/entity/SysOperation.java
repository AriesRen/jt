package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;


@EqualsAndHashCode(callSuper = true)
@Data
public class SysOperation extends BaseEntity {
    private static final long serialVersionUID = -6733804092800020207L;

    private Integer id;
    private String operation;   // 操作名称   删除
    private String name;         // 操作标志   delete
    private String note;         // 操作描述   删除操作

}
