package org.renhj.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象封装
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = 2654393018704671953L;

    private Integer row;             // 记录行数
    private Integer pageCurrent;    // 当前页
    private Integer pageSize;       // 页面大小
    private Integer pageCount;      // 页数
    private List<T> records;        // 本页记录数据
}
