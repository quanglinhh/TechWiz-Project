package com.example.backendv1.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping({"/get-all", "get-all/{pageNo}"})
    public ResponseEntity<Page<Doctors>> getAllDoctor(@PathVariable(required = false) Integer pageNo){
        int pageSize = 20;
        Page<Doctors> doctorList;
        if (pageNo != null){
            doctorList = doctorService.getAllDoctor(pageNo, pageSize);
        }
        else {
            doctorList = doctorService.getAllDoctor(1, pageSize);
        }
        if(doctorList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(doctorList, HttpStatus.OK);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Doctors> getCarById(@PathVariable("id") Long id){
        Optional<Doctors> doctor = doctorService.getDoctorById(id);
        return doctor.map(doctors -> new ResponseEntity<>(doctors, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
        if (bl) {
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