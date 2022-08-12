package com.example.backendv1.controller.view;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.example.backendv1.AppointmentSchedules.Service.AppointmentServiceImpl;
import com.example.backendv1.Doctor.DoctorServiceImpl;
import com.example.backendv1.Doctor.Doctors;
import com.example.backendv1.HealthFacility.FacilityServiceImpl;
import com.example.backendv1.HealthFacility.HealthFacilities;
import com.example.backendv1.UserRole.Model.Users;
import com.example.backendv1.UserRole.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.List;

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

    @GetMapping("/bookDoctorForm/user/{id}")
    public String bookDoctorForm(@PathVariable("id") Long id, Model model){
        Users user = userService.getUserById(id).get();
        model.addAttribute("user",user);
        List<HealthFacilities> healthFacilities = facilityService.getAllHealthFacility();
        model.addAttribute("falities",healthFacilities);
        return "appointmentSchedules/BookingCare";
    }

    @GetMapping("/Appointment/user/{id}")
    public String appointmentForm(@PathVariable("id") Long id, Model model){
        Users user = userService.getUserById(id).get();
        List<AppointmentSchedules> appointments = appointmentService.findByUser(user);
        model.addAttribute("appointments",appointments);
        return "/appointmentSchedules/appointmentSchedule";
    }
}

