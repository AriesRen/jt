package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;


@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenu extends BaseEntity {
    private static final long serialVersionUID = -1272449917254099069L;

    private Long id;
    private String menu;
    private String url;
    private String icon;
    private int status;        // 1 上线 2 下线
    private boolean hidden;   // true 1 不隐藏  false 0 隐藏
    private Integer parentID;
}
