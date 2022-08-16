package com.example.backendv1.controller.view;

import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Controller
public class UserViewController {
    private final String UPLOAD_DIR = "src/main/resources/static/uploads/images/";
    @Autowired
    UserServiceImpl userService;

    public void GetId(
            Model model
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Optional<Users> opUsert = userService.findByEmail(currentPrincipalName);
        Users u;
        if(opUsert.isPresent()) {
            u = opUsert.get();
        } else {
            u = new Users();
        }
        model.addAttribute("currentUserId", u.getId());
        model.addAttribute("image", u.getImage());
        model.addAttribute("name", u.getName());

        System.out.println(u.getId());
    }

    @GetMapping(value = {"/user/{id}"})
    public String showIndex(@PathVariable("id") Long id, Model model){
        Users user = userService.getUserById(id).get();
        model.addAttribute("user",user);

        GetId(model);
        return "user/userInfo";//tên view = tên file html
    }

    @GetMapping ("updateUser")
    public String updateUser(Model model,@RequestParam Long userId){
        Users user = userService.getUserById(userId).get();
        model.addAttribute("user",user);
        return "user/editUser";
    }

    @Transactional
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute  Users users, @RequestParam MultipartFile file){
        Long id = users.getId();
        //add username + password
        Users findUserById = userService.getUserById(id).get();
        users.setUsername(findUserById.getUsername());
        users.setPassword(findUserById.getPassword());
        // check if file is empty
        if (file.isEmpty()) {

        }
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR);
            //String avatar = path.toString();
            users.setImage("/uploads/images/"+fileName);
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return success response
        userService.saveUser(users);
        return "redirect:/user/"+id;
    }

}
