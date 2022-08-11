package com.example.backendv1.UserRole.service;

import com.example.backendv1.UserRole.Model.UserRoles;
import com.example.backendv1.UserRole.Model.Users;

public interface UserRoleService {

    UserRoles findByUserById(Users users);

    UserRoles saveUserRole(UserRoles userRoles);

    void deleteUserRoleByUserById(Users users);
}
