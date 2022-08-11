package com.example.backendv1.controller.view;

import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserViewController {
    @Autowired
    UserServiceImpl userService;
    @GetMapping(value = {"/user/{id}"})

    public String showIndex(@PathVariable("id") Long id, Model model){
        Users user = userService.getUserById(id).get();
        model.addAttribute("user",user);
        return "user/userInfo";//tên view = tên file html
    }

}
