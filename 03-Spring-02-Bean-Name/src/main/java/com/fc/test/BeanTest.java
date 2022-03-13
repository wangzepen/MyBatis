package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

       Student student = (Student) applicationContext.getBean("student1");

        System.out.println(student);
    }
}
