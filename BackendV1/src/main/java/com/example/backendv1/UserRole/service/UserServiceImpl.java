package com.example.backendv1.UserRole.service;

import com.example.backendv1.HealthInformationByDay.Model.HealthInformationByDay;
import com.example.backendv1.UserRole.Model.Roles;
import com.example.backendv1.UserRole.Model.UserRoles;
import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.repository.RoleRepository;
import com.example.backendv1.UserRole.repository.UserRepository;
import com.example.backendv1.UserRole.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UsersService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleServiceImp roleService;

    @Autowired
    UserRolesServiceImp userRolesService;
    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Page<Users> getAllUsers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return userRepository.findAll(pageable);
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
    public Users saveUser(Users user) {
        UserRoles userRoles = new UserRoles();
        userRoles.setUsersByUserId(user);
        Roles role = roleService.findByRoleName("USER");
        userRoles.setRolesByRoleId(role);
        Collection<UserRoles> userRolesCollection = new ArrayList<>();
        userRolesCollection.add(userRoles);
        role.setUserRolesById(userRolesCollection);
        userRolesService.saveUserRole(userRoles);

        return userRepository.save(user);
    }
    @Override
    public void deleteUserById(Long id) {
        Users user = userRepository.findById(id).get();
        if(userRepository.findById(id).isPresent()){
            userRolesService.deleteUserRoleByUserById(user);
            userRepository.delete(user);
        }
    }

}
