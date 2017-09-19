package com.example.demo.controller;

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
    @RequestMapping("/test")
    public String index(){
        return "test";
    }

    @RequestMapping("/hello/{name}")
	public String fuck(@PathVariable String name) {
		return "fuck " + name;
	}
}
