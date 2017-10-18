package com.example.demo.service;

import com.example.demo.domain.UserResouce;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by Administrator on 2017/10/12.
 */

public interface  UserService {
    int add(UserResouce userResouce);
    int update(UserResouce userResouce);
    int deleteByIds(String[] ids);
    UserResouce queryLearnResouceById(Long UserResouce);
    List<UserResouce> queryLearnResouceList(Map<String, Object> params);
}
