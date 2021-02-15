package com.xieli.community;

import com.xieli.community.entity.Message;
import com.xieli.community.service.MessageService;
import com.xieli.community.util.CommunityConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xieli on 2021/2/2.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MyTests implements CommunityConstant {

    @Autowired
    private MessageService messageService;


    @Test
    public void testNotice() {
        // 查询评论类通知
        Message message = messageService.findLatestNotice(281, TOPIC_COMMENT);

    }

}
