package com.knits.spring.common.model;

import lombok.Data;

@Data
public class Customer {

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
