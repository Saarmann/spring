package com.knits.spring.common.com.kaspar.demo;


import com.knits.spring.common.utils.BeanUtils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Service

public class CustomerService {

    @Autowired
    private CustomerDaoImpl customerDaoImpl; //from bean

    public void showCustomers (){

        List <Customer> dtoCustomer = customerDaoImpl.myCustomerList();
        List <CustomerDto> customersAsDtos= new ArrayList<>();
        dtoCustomer.forEach(customer -> customersAsDtos.add(BeanUtils.toModelDto(customer)));
        for (CustomerDto element : customersAsDtos) {
			System.out.println(element);
		};

    }


}