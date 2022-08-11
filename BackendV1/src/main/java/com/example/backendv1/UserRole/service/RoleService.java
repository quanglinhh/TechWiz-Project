package com.example.backendv1.UserRole.service;

import com.example.backendv1.UserRole.Model.Roles;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {
    ResponseEntity<Roles> findByName(String name);
    Roles findByRoleName(String name);

    ResponseEntity<List<Roles>> findAll();

}
