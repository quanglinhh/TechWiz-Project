package com.example.backendv1.service;

import com.example.backendv1.Model.UserRoles;
import com.example.backendv1.Model.Users;
import com.example.backendv1.repository.RoleRepository;
import com.example.backendv1.repository.UserRepository;
import com.example.backendv1.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UsersService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;
    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(Long id) {

        return userRepository.findById(id);
    }

    @Override
    public Users updateUserById(Long id, Users usersUpdate) {
        if(userRepository.findById(id).isPresent()){
            usersUpdate.setId(id);
            usersUpdate.setCreatedAt(userRepository.findById(id).get().getCreatedAt());
        }
        return userRepository.save(usersUpdate);
    }



    @Override
    public Users saveUser(Users user) {;
        return userRepository.save(user);
    }

    @Override
    public Users addUser(Users user) {
        UserRoles userRoles = new UserRoles();
        userRoles.setUsersByUserId(user);
        userRoles.setRolesByRoleId(roleRepository.findById((short) 2).get());
        Collection<UserRoles> userRolesCollection = new ArrayList<>();
        userRolesCollection.add(userRoles);
        userRoleRepository.save(userRoles);
        user.setUserRolesById(userRolesCollection);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        Users user = userRepository.findById(id).get();
        if(userRepository.findById(id).isPresent()){
            userRepository.delete(user);
        }
    }
}
