package com.deity.restful.controller;

import com.deity.restful.entity.ResponseEntity;
import com.deity.restful.exception.ApiException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * Created by Deity on 2017/7/20.
 */

@SuppressWarnings("unused")
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**RestApi Exception*/
    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ResponseEntity jsonErrorHandler(HttpServletRequest req, ApiException e)  {
        ResponseEntity entity = new ResponseEntity();
        entity.setMessage(e.getMessage());
        entity.setStatus(ResponseEntity.ResultCode.FAIL.getCode());
        return entity;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        // Otherwise setup and send the user to a default error-view.
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        System.err.println("exception:"+e.getMessage()+" url:"+req.getRequestURL());
        return mav;
    }
}
