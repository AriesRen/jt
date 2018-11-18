package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenu extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1272449917254099069L;

    public SysMenu(){
        super();
    }

    private Integer id;
    private String menu;
    private String url;
    private String icon;
    private String status;
    private Integer parentID;
}
