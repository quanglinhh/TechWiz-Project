package com.example.backendv1.Auth;

import com.example.backendv1.Auth.Common.Const;
import com.example.backendv1.MailSender.MailSenderService;
import com.example.backendv1.UserRole.Model.Roles;
import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.service.RoleService;
import com.example.backendv1.UserRole.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AuthController {

    @Autowired
    UsersService usersService;

    @Autowired
    RoleService roleService;

    @Autowired
    MailSenderService mailSenderService;

    @GetMapping("/login")
    public String login() {
        return "Auth/login";
    }

    @GetMapping("/register")
    public String register(
            Model model
    ) {
        model.addAttribute("users", new Users());

        return "Auth/register";
    }

    @PostMapping("/process_register")
    public String processRegister(
            Users user
    ) {
        if (usersService.existsByEmail(user.getEmail())) {
            return "redirect:/";
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPass = encoder.encode(user.getPassword());
            user.setPassword(encodedPass);

            Set<Roles> roles = new HashSet<>();
            Roles role = roleService.findByName(Const.ROLE_ADMIN).get();

            roles.add(role);
            user.setRoles(roles);

            usersService.save(user);
        }

        return "redirect:/login";

    }

//    @GetMapping("/sendMail")
//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail() {
//        mailSenderService.sendEmail(
//                "buck110503@gmail.com",
//                "This is title to TripleDot TechWiz 2022",
//                "This is body to TripleDot TechWiz 2022"
//        );
//
////        return "redirect:/ok";
//    }

    @GetMapping("/ok")
    public String ok() {
        return "Auth/ok";
    }

    @GetMapping("")
    public String home() {
        return "Auth/ok";
    }

    @GetMapping("/appointment")
    public String appoi() {
        return "Appointment/index";
    }
}
