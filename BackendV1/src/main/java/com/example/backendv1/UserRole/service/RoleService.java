package com.example.backendv1.UserRole.service;

import com.example.backendv1.UserRole.Model.Roles;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByName(String name);

    Roles findByRoleName(String name);

    ResponseEntity<List<Roles>> findAll();
}
