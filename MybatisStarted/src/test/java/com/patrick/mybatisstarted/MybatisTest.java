package com.patrick.mybatisstarted;

import com.patrick.mybatisstarted.po.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void findCustomerByIdTest() throws IOException {
        String resource = "mybatis-config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = sqlSession.selectOne("mybatis-config.mapper.CustomerMapper.findCustomerById", 1);
//        路径这里少写了一个点
        System.out.println(customer.toString());
        sqlSession.close();
    }
}
