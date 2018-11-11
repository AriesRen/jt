package org.renhj.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResultCodeTest {

    @Test
    public void getCode() {
        ResultCode resultCode = ResultCode.USERNAME_PASSWORD_ERROR;
        System.out.println(resultCode.getCode());
    }

    @Test
    public void getMessage() {
    }
}