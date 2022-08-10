package com.example.backendv1.service;

import com.example.backendv1.Model.Users;
import com.example.backendv1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> getAllUsers();

    Optional<Users> getUserById(Long id);

    Users updateUserById(Long id, Users users);

    void deleteUserById(Long id);


    Users saveUser(Users user);

    Users addUser(Users users);
}
