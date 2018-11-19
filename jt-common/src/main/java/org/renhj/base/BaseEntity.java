package org.renhj.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private Date createdTime;      // 创建时间
    private String createdUser;    // 谁创建的
    private Date updatedTime;      // 修改时间
    private String updatedUser;    // 修改用户

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreatedTime(){
        return this.createdTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
}
