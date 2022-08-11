package com.example.backendv1.DrugDosages.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/web")
public class DrugDosageController2 {

    @GetMapping(path = "/index")
    public String getAll(Model model){
        return "DrugDosagesUsage/menu/Footer/index";
    }
    @GetMapping(path = "/drug")
    public String getdrug(){
        return "DrugDoseUsage/drugdosage";
    }
}
