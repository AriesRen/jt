package org.renhj.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private Date createdTime;      // 创建时间
    private String createdUser;    // 谁创建的
    private Date updatedTime;      // 修改时间
    private String updatedUser;    // 修改用户

    @JSONField(format ="yyyy-MM-dd HH:mm:ss")
    public Date getCreatedTime(){
        return this.createdTime;
    }
    @JSONField(format ="yyyy-MM-dd HH:mm:ss" )
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
}
