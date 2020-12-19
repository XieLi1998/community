package com.xieli.community.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by xieli on 2020/12/2.
 */
@Service
//@Scope("prototype")
public class TestService {

    /**
     *
     *
        public TestService() {
            System.out.println("实例化 TestService");
        }

        //构造器之后调用，用来初始化某些数据
        @PostConstruct
        public void init() {
            System.out.println("初始化 TestService");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("销毁 TestService");
        }

     */

}
