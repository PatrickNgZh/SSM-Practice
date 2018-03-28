package com.patrick.mybatisstarted.data;

import com.patrick.mybatisstarted.po.Customer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author peicong
 * @date 2018/3/28 0028
 */
public interface CustomerMapper {
    @Select("SELECT * " +
            "FROM tb_customer " +
            "WHERE id=#{id};")
    public Customer retrieveCustomerById(int id);


    @Insert("INSERT INTO tb_customer VALUES " +
            "  (#{id}, #{username}, #{jobs}, #{phone});")
    public int insertCustomer(Customer customer);

    @Delete("DELETE FROM tb_customer " +
            "WHERE id =#{id};")
    public int deleteCustomerById(int id);
}
