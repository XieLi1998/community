package com.xieli.community;

import com.xieli.community.dao.DiscussPostMapper;
import com.xieli.community.dao.UserMapper;
import com.xieli.community.entity.DiscussPost;
import com.xieli.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

/**
 * Created by xieli on 2020/12/19.
 */

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    public DiscussPostMapper discussPostMapper;

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
    public void testInsertUser() {
        User user = new User();
        user.setUsername("xieli");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("xieli@qq.com");
        user.setHeadUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : list) {
            System.out.println(post);
        }
    }

}
