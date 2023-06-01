package com.cc.community.dao;

import com.cc.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jiawei
 * @create 2023/05/24
 */


@Mapper
public interface UserMapper {

    User selectById(int id);
    User selectByName(String username);
    User selectByEmail(String email);

    int insertUser(User user);
    int updateStatus(int id,int status);
    int updateHeader(int id,String headerUrl);
    int updatePassword(int id,String password);

}
