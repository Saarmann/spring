package com.knits.spring.common.utils;

import com.knits.spring.common.com.kaspar.demo.CustomerDto;
import com.knits.spring.common.beans.UserDto;
import com.knits.spring.common.com.kaspar.demo.Customer;
import com.knits.spring.common.model.User;

public class BeanUtils {

	
	public static User dto2Model(UserDto dto){
		User user = new User();
		String [] tokens= dto.getName().split("[ ]");
		user.setFirstName(tokens[0]);
		user.setLastName(tokens[1]);
		user.setEmail(dto.getEmail());
		user.setTelephone(dto.getTelephone());
		user.setCity(dto.getCity());
		return user;
	}
	
	public static UserDto model2Dto(User model){
		UserDto dto = new UserDto();
		dto.setName(model.getFirstName()+" "+model.getLastName());
		dto.setEmail(model.getEmail());
		dto.setTelephone(model.getTelephone());
		dto.setCity(model.getCity());
		return dto;
	}

	public static CustomerDto toModelDto (Customer model) {

		CustomerDto dto = new CustomerDto ();
		dto.setId(model.getId());
		dto.setCustomerName(model.getCustomerName());
		dto.setRegistrationCode(model.getRegistrationCode());
		dto.setVatNo(model.getVatNo());
		dto.setAddress(model.getAddress());
		dto.setCity(model.getCity());
		dto.setState(model.getState());
		dto.setCountry(model.getCountry());
		dto.setZip(model.getZip());
		dto.setCustomerEmail(model.getCustomerEmail());
		dto.setContact(model.getContact());
		dto.setPaymentTerm(model.getPaymentTerm());
		return dto;

	}

}
