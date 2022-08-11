package com.example.backendv1.UserRole.service;

import com.example.backendv1.UserRole.Model.Roles;

public interface RoleService {
    Roles findByName(String name);
}
