package com.cc.community.service;

import com.cc.community.dao.UserMapper;
import com.cc.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiawei
 * @create 2023/05/26
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(int id){
        User user = userMapper.selectById(id);
        return user;
    }


}
