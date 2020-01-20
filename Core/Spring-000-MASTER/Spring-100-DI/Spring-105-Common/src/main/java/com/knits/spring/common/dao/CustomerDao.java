package com.knits.spring.common.dao;

import com.knits.spring.common.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> myCustomerList();

    public void addNewCustomer(Customer customer);

    public void editCustomer(int id);

}
