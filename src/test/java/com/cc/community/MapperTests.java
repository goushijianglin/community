package com.cc.community;

import com.cc.community.dao.DiscussPostMapper;
import com.cc.community.dao.UserMapper;
import com.cc.community.entity.DiscussPost;
import com.cc.community.entity.User;
import com.cc.community.service.DiscussPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

/**
 * @author jiawei
 * @create 2023/05/24
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private DiscussPostService discussPostService;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);
        user = userMapper.selectByName("liubei");
        System.out.println(user);
        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("123456789");
        user.setSalt("abc");
        user.setEmail("ttt111@gmail.com");
        user.setHeaderUrl("http://www.nowcoder.com/100t.png");
        user.setCreateTime(new Date());

        int rows=userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
        User user1 = userMapper.selectById(user.getId());
        System.out.println(user1);

    }
    @Test
    public void updateUser(){
        User user = userMapper.selectById(150);
        System.out.println(user);
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);
    rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        rows = userMapper.updatePassword(150, "987654");
        user = userMapper.selectById(150);
        System.out.println(user);
    }
    @Test
    public void discussPost(){
        List<DiscussPost> discussPosts = discussPostService.getDiscussPosts(0, 1, 10);
        for(DiscussPost discussPost:discussPosts){
            System.out.println("discussPost = " + discussPost);
        }

    }
}
