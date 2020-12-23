package com.xieli.community;

import com.xieli.community.util.CommunityUtil;
import com.xieli.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by xieli on 2020/12/22.
 */

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClient.sendMail("2524546110@qq.com", "Test", "这不是偶然");
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "xieli");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("2524546110@qq.com", "HTML", content);
    }

    @Test
    public void testCommunityUtil() {
        System.out.println(CommunityUtil.generateUUID());
    }

}
