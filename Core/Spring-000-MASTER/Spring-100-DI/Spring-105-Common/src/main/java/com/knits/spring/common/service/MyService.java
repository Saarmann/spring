package com.knits.spring.common.service;

import com.knits.spring.common.beans.UserDto;
import com.knits.spring.common.dao.UserDao;
import com.knits.spring.common.integration.UserJmsClient;
import com.knits.spring.common.model.User;
import com.knits.spring.common.utils.BeanUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class MyService {

//    @Autowired
    private UserJmsClient jmsClient;

//    @Autowired
    private UserDao userDao;


    public void feature(UserDto user){
          jmsClient.sendUserToJmsQueue(user);
          User userEntity = BeanUtils.dto2Model(user);
          userDao.persist(userEntity);
    }
}
