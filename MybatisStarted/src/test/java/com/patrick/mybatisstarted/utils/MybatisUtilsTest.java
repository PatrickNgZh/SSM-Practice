package com.patrick.mybatisstarted.utils;

import com.patrick.mybatisstarted.po.Customer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author peicong
 * @date 2018/2/11 0011
 */
public class MybatisUtilsTest {

    @Test
    public void getSession() {
        SqlSession sqlSession = MybatisUtils.getSession();
        Customer customer = sqlSession.selectOne("com.patrick.mybatisstarted" +
                ".mapper.CustomerMapper.findCustomerById", 2);
        System.out.println(customer.toString());
        sqlSession.close();
    }
}