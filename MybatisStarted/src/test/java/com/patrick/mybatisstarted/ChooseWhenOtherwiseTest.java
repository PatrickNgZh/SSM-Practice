package com.patrick.mybatisstarted;

import com.patrick.mybatisstarted.po.Customer;
import com.patrick.mybatisstarted.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author peicong
 * @date 2018/2/11 0011
 */
public class ChooseWhenOtherwiseTest {
    @Test
    public void findCustomerByNameOrJobs() {
        SqlSession sqlSession = MybatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("Jack");
        customer.setJobs("teacher");
        List<Customer> customers = sqlSession.selectList("com.patrick" +
                ".mybatisstarted.mapper.CustomerMapper.findCustomerByNameOrJobs", customer);
        for (Customer eachcustomer : customers) {
            System.out.println(eachcustomer);
        }
        sqlSession.close();
    }

    @Test
    public void findCustomerByNull() {
        SqlSession sqlSession = MybatisUtils.getSession();
        Customer customer = new Customer();
        List<Customer> customers = sqlSession.selectList("com.patrick" +
                ".mybatisstarted.mapper.CustomerMapper.findCustomerByNameOrJobs", customer);
        for (Customer eachcustomer : customers) {
            System.out.println(eachcustomer);
        }
        sqlSession.close();
    }
}
