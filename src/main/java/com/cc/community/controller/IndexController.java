package com.cc.community.controller;

import com.cc.community.entity.DiscussPost;
import com.cc.community.entity.Page;
import com.cc.community.entity.User;
import com.cc.community.service.DiscussPostService;
import com.cc.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * @author jiawei
 * @create 2023/05/26
 */
@Controller
public class IndexController {

    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        int rows = discussPostService.getDiscussPostRows(0);
        page.setRows(rows);
        page.setPath("/index");
        List<DiscussPost> discussPostList = discussPostService.getDiscussPosts(0, page.getStartDiscuss(), page.getLimit());
//        discussPosts.stream().map(e->e.getUserId())
        List<Map<String, Object>> discussPosts = new ArrayList<>();

        for(DiscussPost discussPost:discussPostList){
            Map<String,Object> map =new HashMap<>();
            map.put("post",discussPost);
            User user = userService.getUserById(discussPost.getUserId());

            map.put("user", user);
            discussPosts.add(map);
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }
}
