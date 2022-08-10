package com.example.backendv1.controller;

import com.example.backendv1.Model.Roles;
import com.example.backendv1.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/{id}")
    public Roles findRoleById(@PathVariable("id") short id){
        return roleRepository.findById(id).get();
    }
}
