package com.example.ui.service;


import com.example.ui.model.Role;

public interface RoleService {
     Role saveRole(Role role);
     Role findById(long id);

}
