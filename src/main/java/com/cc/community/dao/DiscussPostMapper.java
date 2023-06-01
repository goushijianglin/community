package com.cc.community.dao;

import com.cc.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiawei
 * @create 2023/05/26
 */
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPostList(int userId,int startDiscuss, int limit);
    int selectDiscussPostRows(@Param("userId") int userId);

}
