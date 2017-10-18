package com.example.demo.controller;

import com.example.demo.domain.TestBean;
import com.example.demo.domain.UserResouce;
import com.example.demo.service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.ServletUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * Created by Administrator on 2017/9/19.
 */

@RestController
//@RequestMapping("/index")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
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

    /**
     * 新添教程
     * @param request
     * @param response
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addLearn(HttpServletRequest request , HttpServletResponse response){
        JSONObject result=new JSONObject();
        String name = request.getParameter("name");
        String years = request.getParameter("years");
        String password = request.getParameter("password");

        UserResouce userResouce = new UserResouce();

        userResouce.setName(name);
        userResouce.setYears(years);
        userResouce.setPassword(password);
        logger.info(name);
        int index = userService.add(userResouce);
        if(index>0){
            result.put("message","用户信息添加成功!");
            result.put("flag",true);
        }else{
            result.put("message","用户信息添加失败!");
            result.put("flag",false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }
}
