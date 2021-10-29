package com.example.ui.service;


import com.example.ui.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {

     User findUserByUsername(String userName);

     User saveUser(User user);
     Page<User> getAllUser(Pageable pageable);
     void delUserById(long id);
}
