package org.renhj.common.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private Integer total;
    private Integer size;
    private Integer current;
    private Integer page;
    private List<?> records;
}
