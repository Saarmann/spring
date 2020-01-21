package com.knits.spring.common.service;


import com.knits.spring.common.beans.CustomerDto;
//import com.knits.spring.common.dao.CustomerDao;
import com.knits.spring.common.dao.CustomerDaoImpl;
import com.knits.spring.common.model.Customer;
import com.knits.spring.common.utils.BeanUtils;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;



public class CustomerService {

    private CustomerDaoImpl customerDaoImpl;


    public List<CustomerDto> showCustomers (){

        List <Customer> dtoCustomer = customerDaoImpl.myCustomerList();
        List <CustomerDto> customersAsDtos= new ArrayList<>();
        dtoCustomer.forEach(customer -> customersAsDtos.add(BeanUtils.toModelDto(customer)));

        return customersAsDtos;

    }


}