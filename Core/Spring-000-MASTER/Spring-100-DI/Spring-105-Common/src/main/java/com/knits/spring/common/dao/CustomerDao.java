package com.knits.spring.common.dao;

import com.knits.spring.common.beans.CustomerDto;
import com.knits.spring.common.model.Customer;

import java.util.List;

public interface CustomerDao {

  public List<Customer> myCustomerList();


}
