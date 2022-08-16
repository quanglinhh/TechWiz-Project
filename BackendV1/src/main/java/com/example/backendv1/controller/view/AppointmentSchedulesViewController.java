package com.example.backendv1.controller.view;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.example.backendv1.AppointmentSchedules.Service.AppointmentServiceImpl;
import com.example.backendv1.Doctor.DoctorServiceImpl;
import com.example.backendv1.HealthFacility.FacilityServiceImpl;
import com.example.backendv1.HealthFacility.HealthFacilities;
import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentSchedulesViewController {
    @Autowired
    AppointmentServiceImpl appointmentService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    DoctorServiceImpl doctorService;

    @Autowired
    FacilityServiceImpl facilityService;

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
    }

    @GetMapping("/bookDoctorForm/user/{id}")
    public String bookDoctorForm(@PathVariable("id") Long id, Model model){
        Users user = userService.getUserById(id).get();
        model.addAttribute("user",user);
        List<HealthFacilities> healthFacilities = facilityService.getAllHealthFacility();
        model.addAttribute("falities",healthFacilities);

        GetId(model);
        return "appointmentSchedules/BookingCare";
    }

    @GetMapping("/Appointment/user/{id}")
    public String appointmentForm(@PathVariable("id") Long id, Model model){
        LocalDate getCurrentTime = LocalDate.now();
        Date currentTime = java.sql.Date.valueOf(getCurrentTime);
        Users user = userService.getUserById(id).get();
        List<AppointmentSchedules> appointments = appointmentService.findByUser(user);
        model.addAttribute("appointments",appointments);

        GetId(model);
        return "appointmentSchedules/appointmentSchedule";
    }


//    @GetMapping("deleteAppointment")
//    public String deleteAppointment(@RequestParam Long appId , Model model){
//        String message = "";
//        AppointmentSchedules appointmentSchedules = appointmentService.findById(appId).get();
//        model.addAttribute("message",message);
//        return "/appointmentSchedules/appointmentSchedule";


//    }
}

