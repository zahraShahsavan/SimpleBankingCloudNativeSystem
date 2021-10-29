package com.example.ui.service;


import com.example.ui.model.Role;
import com.example.ui.model.User;
import com.example.ui.repository.UserRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.example.ui.controller.SignupController.Roles.*;


@Service
public class UserServiceImpl implements UserService, InitializingBean {


    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService) {
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        final User return_user;
        return_user=  userRepository.save(user);
        return return_user;
    }

    @Override
    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void delUserById(long id) {
        userRepository.deleteById(id);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        Role role = new Role();
        role.setId(ROLE_ADMIN);
        role.setName(ROLE_1);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRoles(roleSet);
        this.saveUser(user);

        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword("user");
        Role role2 = new Role();
        role2.setId(ROLE_USER);
        role2.setName(ROLE_2);
        Set<Role> roleSet2 = new HashSet<>();
        roleSet2.add(role2);
        user2.setRoles(roleSet2);
        this.saveUser(user2);

    }
}