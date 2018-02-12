package com.patrick.mybatisspring.dao.impl;

import com.patrick.mybatisspring.dao.CustomerDao;
import com.patrick.mybatisspring.po.Customer;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author peicong
 * @date 2018/2/12 0012
 */
public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao {
    @Override
    public Customer findCustomerById(Integer id) {
        return this.getSqlSession().selectOne("com.patrick.mybatisspring.po" +
                ".CustomerMapper.findCustomerById", id);
    }
}
