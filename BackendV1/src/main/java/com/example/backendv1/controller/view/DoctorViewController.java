package com.example.backendv1.controller.view;

import com.example.backendv1.Doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DoctorViewController {
    @Autowired
    DoctorService doctorService;

}
