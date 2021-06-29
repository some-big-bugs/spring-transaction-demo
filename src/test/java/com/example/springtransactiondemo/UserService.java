package com.example.springtransactiondemo;

import com.example.springtransactiondemo.repository.entity.User;
import com.example.springtransactiondemo.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  @Autowired
  @Lazy
  private UserService userService;

  @Autowired
  private UserMapper userMapper;

  @Transactional
  public void testSave1() {
    User user = new User();
    user.setName("ddddddddddddddd");
    userMapper.insertSelective(user);
    try {
      user.setName("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
      userService.save2(user);
    } catch (Exception e) {
      e.printStackTrace();
      // throw new RuntimeException(e);
    }
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void save2(User user) {
    userMapper.insertSelective(user);
  }
}
