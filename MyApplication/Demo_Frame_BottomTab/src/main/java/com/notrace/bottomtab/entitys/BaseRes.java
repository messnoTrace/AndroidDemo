package com.notrace.bottomtab.entitys;

import java.io.Serializable;

/**
 * Created by notrace on 2015/12/29.
 */
public class BaseRes implements Serializable {
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
