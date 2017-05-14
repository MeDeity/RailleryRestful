package com.deity.restful.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 动态信息
 * Created by Deity on 2017/4/16.
 */
@Entity
public class Dynamic {
    @Id
    @GeneratedValue
    private  Integer id;
    /**动态描述*/
    private String description;
    /**附件地址*/
    private String fileUrl;
    /**附件的宽*/
    private float width;
    /**附件的高*/
    private float height;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
