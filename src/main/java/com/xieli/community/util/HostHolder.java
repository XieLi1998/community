package com.xieli.community.util;

import com.xieli.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by xieli on 2020/12/25.
 */

/**
 * 持有用户信息，用于代替 session 对象
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }
}
