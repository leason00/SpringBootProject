package com.example.demo.service.impl;

/**
 *
 * Created by Administrator on 2017/10/12.
 */
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.UserResouce;
import com.example.demo.service.UserService;
//import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public int add(UserResouce userResouce) {
        return this.userMapper.add(userResouce);
    }

    @Override
    public int update(UserResouce userResouce) {
        return this.userMapper.update(userResouce);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return this.userMapper.deleteByIds(ids);
    }

    @Override
    public UserResouce queryLearnResouceById(Long id) {
        return this.userMapper.queryLearnResouceById(id);
    }

    @Override
    public List<UserResouce> queryLearnResouceList(Map<String, Object> params) {
        return null;
    }

//    @Override
//    public List<LearnResouce> queryLearnResouceList(Map<String,Object> params) {
//        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
//        return this.learnMapper.queryLearnResouceList(params);
//    }
}