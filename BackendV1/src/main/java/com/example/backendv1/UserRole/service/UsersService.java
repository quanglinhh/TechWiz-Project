package com.example.backendv1.UserRole.service;

import com.example.backendv1.UserRole.Model.UserRoles;
import com.example.backendv1.UserRole.Model.Users;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> getAllUsers();

    Page<Users> getAllUsers(int pageNo, int pageSize);

    Optional<Users> getUserById(Long id);

    Users updateUserById(Long id, Users users);

    void deleteUserById(Long id);


    Users saveUser(Users user);

    void save(Users users);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


}
