package org.renhj.manager.pojo.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_role")
public class TbRole implements Serializable {
    @Id
    private Long id;
    private String role;
    private String desc;
    private Date created;
    private Date updated;
}
