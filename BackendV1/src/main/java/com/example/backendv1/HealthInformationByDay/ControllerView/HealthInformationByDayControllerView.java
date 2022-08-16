package com.example.backendv1.HealthInformationByDay.ControllerView;

import com.example.backendv1.HealthInformationByDay.Model.HealthInformationByDay;
import com.example.backendv1.HealthInformationByDay.Service.HealthInformationByDayService;
import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HealthInformationByDayControllerView {
    @Autowired
    HealthInformationByDayService healthInformationByDayService;

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

    //get all
    @GetMapping("/healthInformationByDay")
    public String viewHealthInformationPage(
            Model model ,
            @RequestParam("page")Optional<Integer> page,
            @RequestParam("size")Optional<Integer> size
    ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<HealthInformationByDay> healthInformationByDayPage = healthInformationByDayService.paginationPage(PageRequest.of(currentPage-1,pageSize));
        int ident = 0;
        ident +=1;
        model.addAttribute("i",ident);
        model.addAttribute("healthInformationByDayPage" , healthInformationByDayPage);
        int totalPages =  healthInformationByDayPage.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1 , totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        GetId(model);

        return "healthInformationByDay/healthInformationByDays";
    }


    // to form add
    @GetMapping("/showHealthInformationByDayForm")
    public String showNewHealthInformationForm(Model model) {
        List<Users> usersList = usersService.getAllUsers();
        model.addAttribute("healthInformationByDay", new HealthInformationByDay());
        model.addAttribute("usersList", usersList);

        return "healthInformationByDay/healthInformationByDay_form";
    }

    //save
    @PostMapping("/saveHealthInformationByDay")
    public String saveHealthInformation(
            @ModelAttribute("healthInformationByDays") HealthInformationByDay healthInformationByDay
    ) {
        //save employee database
        healthInformationByDayService.saveHealthInformationByDay(healthInformationByDay);

        return "redirect:/healthInformationByDay";
    }

    //Update
    @GetMapping("/showFormUpdateHealthInformation/{id}")
    public String showFormForUpdateHealthInformation(@PathVariable(value = "id") long id, Model model) {
        //get employee the service
        HealthInformationByDay healthInformationByDays = healthInformationByDayService.getHealthInformationById(id);
        model.addAttribute("healthInformationByDay", healthInformationByDays);
        //set employee as a model attribute to pre-populate the form
        List<Users> usersList = usersService.getAllUsers();
        model.addAttribute("usersList", usersList);

        return "healthInformationByDay/healthInformationByDay_formUpdate";
    }

    //delete
    @GetMapping("/deleteHealthInformation/{id}")
    public String deleteClass(@PathVariable (value = "id") long id) {
        //call delete employee method
        this.healthInformationByDayService.deleteHealthInformationByDay(id);
        return "redirect:/healthInformationByDay";
    }

}
