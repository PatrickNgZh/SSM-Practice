package com.patrick.mybatisstarted.data;

import com.patrick.mybatisstarted.po.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author peicong
 * @date 2018/3/28 0028
 */
public class CustomerMapperTest {
    @Test
    public void retrieveCustomerById() throws IOException {
        String resource = "mybatis-config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.retrieveCustomerById(1);
//        Customer customer = sqlSession.selectOne("com.patrick.mybatisstarted" +
//                ".mapper.CustomerMapper.findCustomerById", 2);
//        路径这里少写了一个点
        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void insertCustomer() throws IOException {
        String resource = "mybatis-config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = new Customer();
        customer.setId(5);
        customer.setUsername("lily");
        customer.setJobs("teacher");
        customer.setPhone("13676665766");
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        System.out.println(customerMapper.insertCustomer(customer));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteCustomerById() throws IOException {
        String resource = "mybatis-config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        System.out.println(customerMapper.deleteCustomerById(5));
        sqlSession.rollback();
        sqlSession.commit();
        sqlSession.close();
    }
}