package com.deity.restful.entity;

/**
 * Created by Deity on 2017/4/17.
 */
public class Data {

    public enum ResultCode {

        SUCCESS(1),FAIL(0);

        private int code;

        ResultCode(int code){
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    private String message;
    private Integer status;
    private Object Data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", Data=" + Data +
                '}';
    }
}
