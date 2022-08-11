package com.example.backendv1.DrugDosages.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "web")
public class DrugDosagesController2 {

    @GetMapping(path = "/drug")
    public String getAll(){
        return "DrugDoseUsage/drugdosage";
    }
}
