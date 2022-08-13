package com.example.backendv1.ControllerView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("home")
    public String home() {
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
}
