package com.xieli.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

//    @Test
//    public void testApplicationContext() {
//        System.out.println(applicationContext);
//
//        TestDao testDao = applicationContext.getBean(TestDao.class);
//        System.out.println(testDao.select());
//
//        testDao = applicationContext.getBean("testDao", TestDao.class);
//        System.out.println(testDao.select());
//    }

//    @Test
//    public void testBeanManager() {
//        TestService testService = applicationContext.getBean(TestService.class);
//        System.out.println(testService);
//
//        testService = applicationContext.getBean(TestService.class);
//        System.out.println(testService);
//    }

    @Test
    public void testBeanConfig() {
        SimpleDateFormat simpleDateFormat =
                applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

//    @Autowired
//    @Qualifier("testDao")
//    private TestDao testDao;

//    @Autowired
//    private TestService testService;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

//    @Test
//    public void testDI() {
//        System.out.println(testDao);
//        System.out.println(testService);
//        System.out.println(simpleDateFormat);
//    }
}
