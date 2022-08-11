package com.example.backendv1.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping("/get-all")
    public ResponseEntity<List<Doctors>> getAllDoctor(){
        List<Doctors> doctorList = doctorService.getAllDoctor();
        if (doctorList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Doctors>>(doctorList, HttpStatus.OK);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Doctors> getCarById(@PathVariable("id") Long id){
        Optional<Doctors> doctor = doctorService.getDoctorById(id);
        if (doctor.isPresent()){
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<Doctors> addDoctor (@RequestBody Doctors doctor) {
        try {
            doctorService.addDoctor(doctor);
            return ResponseEntity.ok(doctor);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Doctors> deleteDoctor(@RequestParam("id") long id) {
        boolean bl = doctorService.deleteDoctor(id);
        if (bl == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping ("/update")
    public ResponseEntity<Doctors> updateDoctor (@RequestParam("id") Long id,@RequestBody Doctors doctor) {
        try {
            doctorService.updateDoctor(id,doctor);
            return ResponseEntity.ok(doctor);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}