package com.xieli.community.controller;

import com.xieli.community.entity.User;
import com.xieli.community.service.FollowService;
import com.xieli.community.util.CommunityUtil;
import com.xieli.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xieli on 2021/1/11.
 */
@Controller
public class FollowController {

    @Autowired
    private FollowService followService;

    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = "/follow", method = RequestMethod.POST)
    @ResponseBody
    public String follow(int entityType, int entityId) {
        User user = hostHolder.getUser();

        followService.follow(user.getId(),entityType, entityId);

        return CommunityUtil.getJSONString(0,"已关注！");
    }

    @RequestMapping(path = "/unfollow", method = RequestMethod.POST)
    @ResponseBody
    public String unfollow(int entityType, int entityId) {
        User user = hostHolder.getUser();

        followService.unfollow(user.getId(),entityType, entityId);

        return CommunityUtil.getJSONString(0,"已取消关注！");
    }



}
