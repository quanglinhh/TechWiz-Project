package com.example.backendv1.controller.view;

import com.example.backendv1.Doctor.DoctorService;
import com.example.backendv1.Doctor.Doctors;
import com.example.backendv1.HealthFacility.FacilityService;
import com.example.backendv1.HealthFacility.HealthFacilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DoctorViewController {
    @Autowired
    DoctorService doctorService;

}
