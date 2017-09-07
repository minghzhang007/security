package com.lewis.security.domain;

public class Response {

    private boolean success;

    private String msg;

    private Object data;

    private int resultCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Response() {
    }

    public Response(boolean success, String msg, Object data, int resultCode) {
        this.success = success;
        this.msg = msg;
        this.data = data;
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", resultCode=" + resultCode +
                '}';
    }
}
