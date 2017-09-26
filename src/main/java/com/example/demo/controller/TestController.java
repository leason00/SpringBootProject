package com.example.demo.controller;

import com.example.demo.domain.TestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
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
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        TestBean testBean = new TestBean(account, name);
        logger.info(testBean.toString());

		return testBean;
	}
}
