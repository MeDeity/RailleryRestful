package com.deity.restful.controller;

import com.deity.restful.dao.DynamicRepository;
import com.deity.restful.entity.Dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Deity on 2017/4/16.
 */
@RestController
public class DynamicController {
    @Autowired
    private DynamicRepository dynamicRepository;

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



}
