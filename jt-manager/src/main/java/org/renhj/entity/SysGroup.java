package org.renhj.entity;

import org.renhj.base.BaseEntity;

import java.io.Serializable;

public class SysGroup extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3132589566810636773L;

    public SysGroup(){
        super();
    }

    private Integer id;
    private String group;
    private Integer parentID;
}
