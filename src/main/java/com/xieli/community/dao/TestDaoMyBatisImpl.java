package com.xieli.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by xieli on 2020/11/26.
 */
@Repository
@Primary
public class TestDaoMyBatisImpl implements TestDao{
    @Override
    public String select() {
        return "MyBatis";
    }
}
