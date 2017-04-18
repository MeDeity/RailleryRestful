package com.deity.restful.controller;

import com.deity.restful.dao.DynamicRepository;
import com.deity.restful.entity.ResponseEntity;
import com.deity.restful.entity.Dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Deity on 2017/4/16.
 */
@RestController
@SuppressWarnings("unused")
public class DynamicController {
    @Autowired
    private DynamicRepository dynamicRepository;
    @Autowired
    private Environment env;

    /**查询所有动态数据*/
    @GetMapping(value = "/dynamic")
    private List<Dynamic> dynamicList(){
        return dynamicRepository.findAll();
    }

    /**增加动态信息*/
    @PostMapping(value = "/dynamic")
    private Dynamic addDynamic(@RequestParam("description") String description,@RequestParam("fileUrl") String fileUrl){
        Dynamic dynamic = new Dynamic();
        dynamic.setDescription(description);
        dynamic.setFileUrl(fileUrl);
        return dynamicRepository.save(dynamic);
    }
    @DeleteMapping(value = "/dynamic/{id}")
    private void delDynamic(@PathVariable("id") Integer id){
        dynamicRepository.delete(id);
    }

    @PutMapping(value = "/dynamic/{id}")
    private Dynamic updateDynamic(@PathVariable("id") Integer id, @RequestParam("description") String description, @RequestParam("fileUrl") String fileUrl){
        Dynamic dynamic = new Dynamic();
        dynamic.setId(id);
        dynamic.setDescription(description);
        dynamic.setFileUrl(fileUrl);
        return dynamicRepository.save(dynamic);
    }

    @GetMapping(value = "/dynamic/{id}")
    private Dynamic queryDynamic(@PathVariable("id") Integer id){
        return dynamicRepository.findOne(id);
    }


    @RequestMapping("/fileUpload")
    @ResponseBody
    public ResponseEntity handleFileUpload(@RequestParam("file")MultipartFile multipartFile, @RequestParam("description") String description, @RequestParam("fileUrl") String fileUrl){
        /**获取配置的本地路径* */
        String rootPathDir = env.getProperty("upload.path");
        /**构建按照日期存储的本地路径**/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH");
        String fullPathDir = rootPathDir + File.separator + dateFormat.format(new Date());
        /**根据本地路径创建目录**/
        File fullPathFile = new File(fullPathDir);
        if (!fullPathFile.exists())
            fullPathFile.mkdirs();
        /** 获取文件的后缀* */
        String suffix = multipartFile.getOriginalFilename().substring(
                multipartFile.getOriginalFilename().lastIndexOf("."));
        /** 使用UUID生成文件名称* */
        String fileName = UUID.randomUUID().toString() + suffix;
        /** 拼成完整的文件保存路径加文件* */
        String filePath = fullPathFile + File.separator + fileName;
        /** 文件输出流* */
        File file = new File(filePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             BufferedOutputStream stream = new BufferedOutputStream(fileOutputStream)) {
            stream.write(multipartFile.getBytes());
            /** 打印出上传到服务器的文件的本地路径和网络路径* */
            System.out.println("****************" + filePath + "**************");
            System.out.println("/Files/" + dateFormat.format(new Date()) + "/" + fileName);
            addDynamic(description,fileUrl);//添加到数据库
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(ResponseEntity.ResultCode.FAIL);
        }
        return new ResponseEntity(ResponseEntity.ResultCode.SUCCESS);
    }

}
