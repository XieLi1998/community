package com.xieli.community.dao;

import com.xieli.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xieli on 2020/12/4.
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
