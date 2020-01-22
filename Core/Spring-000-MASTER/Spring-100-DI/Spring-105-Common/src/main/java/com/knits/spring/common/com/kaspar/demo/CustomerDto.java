package com.knits.spring.common.com.kaspar.demo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CustomerDto {

    private int id;
    private String customerName;
    private String registrationCode;
    private String vatNo;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String customerEmail;
    private String contact;
    private int paymentTerm;

}
