package com.xieli.community.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by xieli on 2020/11/26.
 */
@Repository("testDao")
public class TestDaoImpl implements TestDao {

    @Override
    public String select() {
        return "select";
    }

}
