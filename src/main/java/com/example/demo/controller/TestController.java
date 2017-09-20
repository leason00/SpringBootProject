package com.example.demo.controller;

import com.example.demo.domain.TestBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by Administrator on 2017/9/19.
 */

@RestController
//@RequestMapping("/index")
public class TestController {
    //直接引用配置
    @Value("${com.test.test}")
    private String x;

    @RequestMapping("/test")
    public String index(){
        return x;
    }
//http://localhost:8080/hello/leason?account=123
    @RequestMapping("/hello/{name}")
	public TestBean fuck(@PathVariable String name, @RequestParam String account) {
		return new TestBean(account, name);
	}
}
