package com.example.backendv1.UserRole.controller;

import com.example.backendv1.UserRole.Model.Roles;
import com.example.backendv1.UserRole.service.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {
    @Autowired
    RoleServiceImp roleService;

    @GetMapping("/{role}")
    public ResponseEntity<Roles> getRoleByName(@PathVariable("role") String name){
        return roleService.findByName(name);
    }

    @GetMapping
    public ResponseEntity<List<Roles>> getAll(){
        return roleService.findAll();
    }
}
