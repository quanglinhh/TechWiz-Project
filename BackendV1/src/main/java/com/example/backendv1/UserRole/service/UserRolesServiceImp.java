package com.example.backendv1.UserRole.service;

import com.example.backendv1.UserRole.Model.UserRoles;
import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserRolesServiceImp implements UserRoleService{
    @Autowired
    UserRoleRepository userRoleRepository;
    @Override
    public UserRoles findByUserById(Users users) {

        return userRoleRepository.findByUsersByUserId(users);


    }

    @Override
    public UserRoles saveUserRole(UserRoles userRoles) {
        return userRoleRepository.save(userRoles);
    }

    @Override
    public void deleteUserRoleByUserById(Users users) {
        userRoleRepository.deleteByUsersByUserId(users);
    }



}
