package com.example.backendv1.UserRole.Model.Medicines.Controller;

import com.example.backendv1.UserRole.Model.Medicines.Model.Medicines;
import com.example.backendv1.UserRole.Model.Medicines.Service.MedicinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "/medicines")
public class MedicinesController {
    @Autowired
    MedicinesService medicinesService;

    @GetMapping(path = {"", "/page/{pageNo}"})
    ResponseEntity<Page<Medicines>> getAllMedicines(@PathVariable(required = false) Integer pageNo){
        int pageSize = 20;
        Page<Medicines> allMedicinesByPage;
        if(pageNo != null) {
            allMedicinesByPage = medicinesService.getAllMedicinesByPage(pageNo, pageSize);
        }
        else {
            allMedicinesByPage = medicinesService.getAllMedicinesByPage(1, pageSize);
        }
        if(allMedicinesByPage.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allMedicinesByPage, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<Medicines> getMedicinesById(@PathVariable long id){
        Optional<Medicines> medicinesById = medicinesService.getMedicinesById(id);
        if(!medicinesById.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicinesById.get(), HttpStatus.OK);
    }

    @PostMapping(path = "")
    ResponseEntity<Medicines> addMedicines(@RequestBody Medicines medicines){
        int i = medicinesService.addMedicines(medicines);
        if(i == 0) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else {
            return new ResponseEntity<>(medicines, HttpStatus.ACCEPTED);
        }
    }
    @PutMapping(path = "{id}")
    ResponseEntity<Medicines> updateMedicines(@PathVariable long id, @RequestBody Medicines medicines){
        int i = medicinesService.updateMedicines(id, medicines);
        if( i == 1){
            return new ResponseEntity<>(medicines, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(path = "{id}")
    ResponseEntity<Medicines> deleteMedicines(@PathVariable long id){
        int i = medicinesService.deleteMedicines(id);
        if(i == 1){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
