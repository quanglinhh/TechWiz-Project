package com.example.backendv1.controller;

import com.example.backendv1.Model.Users;
import com.example.backendv1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;



    @GetMapping
    List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<Users> addUsers(@RequestBody Users user){
        userService.addUser(user);
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
    public Object deleteUser(@RequestParam Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("Deleted user with id = "+id);
    }

}
