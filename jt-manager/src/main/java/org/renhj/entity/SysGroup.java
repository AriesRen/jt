package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysGroup extends BaseEntity{
    private static final long serialVersionUID = -3132589566810636773L;

    private Long id;
    private String group;
    private Integer parentID;
}
