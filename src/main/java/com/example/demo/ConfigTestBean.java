package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * Created by Administrator on 2017/9/14.
 */
@Configuration
@ConfigurationProperties(prefix = "com.test")
@PropertySource("classpath:test.properties")

public class ConfigTestBean {
    private String test;
    private String test2;

    // 省略getter和setter

    public String getTest() {
        return test;
    }

    public void setTest(String test){
        this.test = test;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2){
        this.test2 = test2;
    }
}
