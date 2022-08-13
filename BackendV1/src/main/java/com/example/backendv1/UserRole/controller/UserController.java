package com.example.backendv1.UserRole.controller;

import com.example.backendv1.UserRole.Model.UserRoles;
import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping(path = "")
    List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = {"/all-user", "/all-user/{pageNo}"})
    ResponseEntity<Page<Users>> getAllUsersByPage(@PathVariable(required = false) Integer pageNo){
        int pageSize = 20;
        Page<Users> usersByPage;
        if(pageNo != null){
            usersByPage = userService.getAllUsers(pageNo, pageSize);
        } else {
            usersByPage = userService.getAllUsers(1, pageSize);
        }
        if(usersByPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usersByPage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Users> addUsers(@RequestBody Users user){
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") long id){
        Users users = userService.getUserById(id).get();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") long id, @RequestBody Users userUpdate){
        Users user = userService.updateUserById(id,userUpdate);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public Object deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("Deleted user with id = "+id);
    }

}
