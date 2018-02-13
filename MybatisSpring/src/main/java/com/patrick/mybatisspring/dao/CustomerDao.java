package com.patrick.mybatisspring.dao;

import com.patrick.mybatisspring.po.Customer;

/**
 * @author peicong
 * @date 2018/2/12 0012
 */
public interface CustomerDao {
    public Customer findCustomerById(Integer id);
}


