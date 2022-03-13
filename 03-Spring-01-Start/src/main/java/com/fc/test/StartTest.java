package com.fc.test;

import com.fc.dao.UserDao;
import org.junit.Test;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTest {

    @Test
    public void test() {
        //获取spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取bean对象
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

        userDao.findAll();

    }
}
