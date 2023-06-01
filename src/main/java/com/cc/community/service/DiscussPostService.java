package com.cc.community.service;

import com.cc.community.dao.DiscussPostMapper;
import com.cc.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiawei
 * @create 2023/05/26
 */
@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> getDiscussPosts(int userId,int startDiscuss, int limit){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPostList(userId, startDiscuss, limit);
        return discussPosts;
    }
    public int getDiscussPostRows(int userId){
        int i = discussPostMapper.selectDiscussPostRows(userId);
        return i;

    };
}
