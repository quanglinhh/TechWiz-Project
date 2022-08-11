package com.example.backendv1.UserRole.service;

import com.example.backendv1.UserRole.Model.Roles;
import com.example.backendv1.UserRole.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Roles findByName(String name) {
        return roleRepository.findByName(name);
    }
}
