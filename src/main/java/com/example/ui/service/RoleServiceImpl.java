package com.example.ui.service;


import com.example.ui.model.Role;
import com.example.ui.repository.RoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.ui.controller.SignupController.Roles.*;

@Service
public class RoleServiceImpl implements RoleService, InitializingBean {
private final RoleRepository roleRepository;

@Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role saveRole(Role role) {


        return roleRepository.save(role);


    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Role role = new Role();
        role.setId(ROLE_USER);
        role.setName(ROLE_1);
        this.saveRole(role);
        role.setId(ROLE_ADMIN);
        role.setName(ROLE_2);
        this.saveRole(role);

    }
}
