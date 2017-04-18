package com.deity.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * 自定义资源映射
 */
@Configuration
public class MyWebConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment env;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //注意路径写法需要加上file:
        registry.addResourceHandler("/Files/**").addResourceLocations( "file:"+env.getProperty("upload.path") + "/");
        super.addResourceHandlers(registry);
    }
}