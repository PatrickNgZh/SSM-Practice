package com.patrick.mybatisstarted.po;

public class Customer {
    private Integer id;
    private String username;
    private String jobs;
    private String phone;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jobs='" + jobs + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getJobs() {
        return jobs;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
