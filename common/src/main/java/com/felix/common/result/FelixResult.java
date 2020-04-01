package com.felix.common.result;

public class FelixResult {
    private int code;
    private String msg;
    private Object data;
    private String status;


    public FelixResult(int code, String msg, Object data, String status) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.status = status;
    }

    public FelixResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
