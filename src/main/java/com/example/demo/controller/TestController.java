package com.example.demo.controller;

import com.example.demo.domain.TestBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by Administrator on 2017/9/19.
 */

@RestController
@RequestMapping("/index")
public class TestController {
    @Value("${com.test.test}")
    private String x;

    @RequestMapping("/test")
    public String index(){
        return x;
    }

    @RequestMapping("/hello/{name}")
	public TestBean fuck(@PathVariable String name) {
		return new TestBean("hello", name);
	}
}
