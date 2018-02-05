package com.patrick.AspectOrientedProgramming.factorybean;

import com.patrick.AspectOrientedProgramming.Dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBeanTest {

    @Test
    public void testUserDao(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");
        userDao.addUser();
        userDao.deleteUser();
        //        打印classpath
//        String s[] = System.getProperty("java.class.path").split(";");
//        for (String string : s) {
//            System.out.println(string);
//        }
    }
}
