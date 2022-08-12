package com.example.backendv1.DrugDosages.Controller;

import com.example.backendv1.DrugDosages.Model.DrugDosages;
import com.example.backendv1.DrugDosages.Service.DrugDosagesService;

import com.example.backendv1.Medicines.Model.Medicines;
import com.example.backendv1.Medicines.Service.MedicinesService;
import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "web")
public class DrugDosagesController2 {
    @Autowired private DrugDosagesService drugDosagesService;
    @Autowired private UsersService usersService;

    @Autowired private MedicinesService medicinesService;
    @GetMapping(path = "/drug")
    public String getAll(){
        return "DrugDoseUsage/drugdose";
    }

    @GetMapping(path = "/drug2/{idUser}")
    public String getAll2(Model model, @PathVariable long idUser){
        List<DrugDosages> listAll = drugDosagesService.getAllDrugDosagesByUserId(idUser);
        listAll.forEach(System.out::println);
        model.addAttribute("listAll", listAll);
        model.addAttribute("idUser", idUser);
        return "DrugDoseUsage/drugdose2";
    }

    @GetMapping(path = "/{idUser}/drug2/sort")
    public String getAll2(Model model, @PathVariable long idUser, @RequestParam(value="sortField") String sortField, @RequestParam(value = "sortDir") String dir){
        List<DrugDosages> listAll = drugDosagesService.getAllDrugDosagesByUserId(idUser);
        listAll.forEach(System.out::println);
        if(sortField.equals("id") && dir.equals("desc")){
            listAll = listAll.stream().sorted((s1, s2) -> (int) (s2.getId() -s1.getId())).collect(Collectors.toList());
        }
        else if (sortField.equals("id") && dir.equals("asc")){
            listAll = listAll.stream().sorted((s1, s2) -> (int) (s1.getId() -s2.getId())).collect(Collectors.toList());
        }
        else if(sortField.equals("medicine") && dir.equals("asc")) {
            listAll = listAll.stream().sorted((s1, s2) -> (s1.getMedicine().getName().compareTo(s2.getMedicine().getName()))).collect(Collectors.toList());
        }
        else if(sortField.equals("medicine") && dir.equals("desc")) {
            listAll = listAll.stream().sorted((s1, s2) -> (s2.getMedicine().getName().compareTo(s1.getMedicine().getName()))).collect(Collectors.toList());
        }
        else if (sortField.equals("quantity") && dir.equals("asc")){
            listAll = listAll.stream().sorted((s1, s2) -> (int) (s1.getQuantity() -s2.getQuantity())).collect(Collectors.toList());
        }
        else if (sortField.equals("quantity") && dir.equals("desc")){
            listAll = listAll.stream().sorted((s1, s2) -> (int) (s2.getQuantity() - s1.getQuantity())).collect(Collectors.toList());
        }
        else if (sortField.equals("perday") && dir.equals("asc")){
            listAll = listAll.stream().sorted((s1, s2) -> Integer.parseInt((s1.getTimePerDay())) - Integer.parseInt(s2.getTimePerDay())).collect(Collectors.toList());
        }
        else if (sortField.equals("perday") && dir.equals("desc")){
            listAll = listAll.stream().sorted((s1, s2) -> Integer.parseInt((s2.getTimePerDay())) - Integer.parseInt(s1.getTimePerDay())).collect(Collectors.toList());
        }
        else if (sortField.equals("perweek") && dir.equals("asc")){
            listAll = listAll.stream().sorted((s1, s2) -> Integer.parseInt((s1.getTimePerWeek())) - Integer.parseInt(s2.getTimePerWeek())).collect(Collectors.toList());
        }
        else if (sortField.equals("perweek") && dir.equals("desc")){
            listAll = listAll.stream().sorted((s1, s2) -> Integer.parseInt((s2.getTimePerWeek())) - Integer.parseInt(s1.getTimePerWeek())).collect(Collectors.toList());
        }
//        else if (sortField.equals("created") && dir.equals("asc")){
//            listAll = listAll.stream().sorted((s1, s2) -> s1.getCreatedAt().compareTo(s2.getCreatedAt())).collect(Collectors.toList());
//        }
//        else if (sortField.equals("created") && dir.equals("desc")){
//            listAll = listAll.stream().sorted((s1, s2) -> s2.getCreatedAt().compareTo(s1.getCreatedAt())).collect(Collectors.toList());
//        }
        model.addAttribute("listAll", listAll);
        model.addAttribute("idUser", idUser);
        return "DrugDoseUsage/drugdose2";
    }

    @RequestMapping("/addDrugForm/{userID}")
    public String showForm(Model model, @PathVariable("userID") Long userId){
        Optional<Users> user = usersService.getUserById(userId);
        List<Medicines> medicinesList = medicinesService.getAllMedicines();
        user.ifPresent(users -> model.addAttribute("user", users));
        model.addAttribute("addDrug", new DrugDosages());
        model.addAttribute("userID", userId);
        model.addAttribute("medicinesList" , medicinesList);

        return "DrugDoseUsage/DrugForm";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("addDrug") DrugDosages drugDosages){
        //drugDosagesService.addDrugDosages(drugDosages);
        return "redirect:/DrugDoseUsage/drugdosage";//will redirect to viewemp request mapping
    }
}
