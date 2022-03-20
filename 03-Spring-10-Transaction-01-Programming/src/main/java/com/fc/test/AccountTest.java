package com.fc.test;

import com.fc.service.impl.AccountServiceImpl;
import com.fc.service.impl.ProgrammingServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void test() {
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProgrammingServiceImpl programmingService = applicationContext.getBean(ProgrammingServiceImpl.class);


        programmingService.transfer(1,2,500L);


    }
}
