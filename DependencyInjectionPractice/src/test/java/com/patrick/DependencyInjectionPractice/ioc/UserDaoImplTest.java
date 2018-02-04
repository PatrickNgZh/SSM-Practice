package com.patrick.DependencyInjectionPractice.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {
    @Test
    public void testSay(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.say();
//        打印classpath
//        String s[] = System.getProperty("java.class.path").split(";");
//        for (String string : s) {
//            System.out.println(string);
//        }
    }
}
