package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * Created by Administrator on 2017/9/14.
 */

@ConfigurationProperties(prefix = "com.leason")
public class ConfigBean {
    private String name;
    private String name2;

    // 省略getter和setter

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2){
        this.name2 = name2;
    }
}