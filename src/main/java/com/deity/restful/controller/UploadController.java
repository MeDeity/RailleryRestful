package com.deity.restful.controller;

import com.deity.restful.entity.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Deity on 2017/4/17.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    //TODO 缺少静态模板引擎导致无法访问?
    @RequestMapping("/select")
    public ModelAndView uploadPage() {
        return new ModelAndView("uploadFile");
    }

    @RequestMapping("/test")
    public String test() {
        return "uploadFile";
    }

    @RequestMapping(value = "/pushData", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity uploadSuccess() {
        ResponseEntity data = new ResponseEntity();

        data.setMessage("cuowu");
        data.setStatus(0);
        data.setData(new ArrayList<>());

        return data;
    }
}
