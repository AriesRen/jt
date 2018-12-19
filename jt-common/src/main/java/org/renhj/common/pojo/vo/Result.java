package org.renhj.common.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = -8224728965686096376L;

    private int c;
    private String m;
    private Object d;

    public static Result build(int c, String m, Object d){
        return new Result(c, m, d);
    }
    public static Result ok(Object d){
        return new Result(200,"ok", d);
    }
}
