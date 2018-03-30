package com.patrick.mybatisstarted;

import com.patrick.mybatisstarted.po.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testFindCustomerById() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = sqlSession.selectOne("com.patrick.mybatisstarted" +
                ".mapper.CustomerMapper.findCustomerById", 2);
//        路径这里少写了一个点
        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void testFindAllInfo() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Customer> customerList = sqlSession.selectList("com.patrick.mybatisstarted" +
                ".mapper.CustomerMapper.findAllInfo");
        for (Customer customer:customerList) {
            System.out.println(customer);
        }
    }
}
