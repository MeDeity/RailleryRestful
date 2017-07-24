package com.deity.restful.exception;

/**
 * 异常处理
 * Created by Deity on 2017/7/24.
 */
public class ApiException extends Exception {

    public ApiException(String message){
        super(message);
    }
}
