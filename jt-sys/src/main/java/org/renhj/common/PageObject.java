package org.renhj.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = 2654393018704671953L;

    // 当前页
    private int pageCurrent=1;
    // 页面大小
    private Integer pageSize=5;
    // 总行数
    private Integer rowCount=0;
    // 总页数
    private int pageCount=0;
    // 当前页数据
    private List<T> records;

}
