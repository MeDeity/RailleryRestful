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

    @RequestMapping(value = "/pushData", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity uploadSuccess() {
        ResponseEntity data = new ResponseEntity();

        data.setMessage("cuowu");
        data.setStatus(0);
        data.setData(new ArrayList<>());

        return data;
    }


    /**
     * 文件上传具体实现方法;
     * 1、文件路径；
     * 2、文件名；
     * 3、文件格式;
     * 4、文件大小的限制;
     * @param file
     * @return
     */
//    @RequestMapping("/testUpload")
//    @ResponseBody
//    public ResponseEntity handleFileUpload(@RequestParam("file")MultipartFile file){
//        ResponseEntity result = new ResponseEntity();
//        if(file.isEmpty()){
//            result.setStatus(ResponseEntity.ResultCode.FAIL.getCode());
//            result.setMessage("File is Empty");
//            result.setData(null);
//            return result;
//        }
//        try {
//            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
//            out.write(file.getBytes());
//            out.flush();
//            out.close();
//            result.setStatus(ResponseEntity.ResultCode.SUCCESS.getCode());
//            result.setMessage("upload File Success");
//        } catch (FileNotFoundException e) {
//            result.setStatus(ResponseEntity.ResultCode.FAIL.getCode());
//            result.setMessage(e.getMessage());
//        } catch (IOException ioe) {
//            result.setStatus(ResponseEntity.ResultCode.FAIL.getCode());
//            result.setMessage(ioe.getMessage());
//        }
//        result.setData(null);
//        return result;
//    }
}
