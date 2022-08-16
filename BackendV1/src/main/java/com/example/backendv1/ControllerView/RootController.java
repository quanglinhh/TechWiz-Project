package com.example.backendv1.ControllerView;

import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.service.UsersService;
//import jdk.internal.access.JavaLangInvokeAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class RootController {
    @Autowired
    UsersService usersService;

    public void GetId(
            Model model
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Optional<Users> opUsert = usersService.findByEmail(currentPrincipalName);
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

    @GetMapping({"home", "", "/"})
    public String home(Model model) {
        GetId(model);

        return "Home/index";
    }

    @GetMapping("about")
    public String about() {
        return "Home/about";
    }

    @GetMapping("doctor")
    public String doctor() {
        return "Home/doctors";
    }

    @GetMapping("blog")
    public String blog() {
        return "Home/blog";
    }

    @GetMapping("blog-single")
    public String blogSingle() {
        return "Home/blog-single";
    }

    @GetMapping("contact")
    public String contact() {
        return "Home/contact";
    }

    @GetMapping("/indexxx")
    public String indexxx(
            Model model
    ) {
        GetId(model);

        return "layout/indexxx";
    }


}
