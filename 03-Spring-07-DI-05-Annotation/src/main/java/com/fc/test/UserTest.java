package com.fc.test;

import com.fc.controller.UserController;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {


        @Test
        public void testIoc() {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

            UserController controller = applicationContext.getBean(UserController.class);
            User user = applicationContext.getBean(User.class);

            List<User> list = controller.findAll();

            System.out.println(list);
            System.out.println(user);
        }
}
