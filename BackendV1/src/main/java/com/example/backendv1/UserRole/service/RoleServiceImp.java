package com.example.backendv1.UserRole.service;

import com.example.backendv1.UserRole.Model.Roles;
import com.example.backendv1.UserRole.Model.UserRoles;
import com.example.backendv1.UserRole.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRolesServiceImp userRolesServiceImp;

    @Override
    public ResponseEntity<Roles> findByName(String name) {
        if(roleRepository.findByName(name.toUpperCase())==null){
           return (ResponseEntity<Roles>) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok(roleRepository.findByName(name.toUpperCase()));
    }

    @Override
    public Roles findByRoleName(String name) {
        UserRoles userRoles = new UserRoles();
        return roleRepository.findByName(name);
    }

    @Override

    public ResponseEntity<List<Roles>> findAll() {
        List<Roles> roles = roleRepository.findAll();
        return  ResponseEntity.ok(roles);

    }


}
