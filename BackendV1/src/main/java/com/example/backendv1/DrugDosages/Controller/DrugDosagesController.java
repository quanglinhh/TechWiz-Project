package com.example.backendv1.DrugDosages.Controller;
import com.example.backendv1.DrugDosages.Model.DrugDosages;
import com.example.backendv1.DrugDosages.Service.DrugDosagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "drug-dosage")
public class DrugDosagesController {
    @Autowired
    DrugDosagesService drugDosagesService;

    @GetMapping(path = {"", "page/{pageNo}"})
    ResponseEntity<Page<DrugDosages>> getAllDrugDosages(@PathVariable(required = false) Integer pageNo){
        int pageSize = 20;
        Page<DrugDosages> list;
        if(pageNo != null) {
            list = drugDosagesService.getAllDrugDosagesByPage(pageNo, pageSize);
        } else {
            list = drugDosagesService.getAllDrugDosagesByPage(1, pageSize);
        }
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<DrugDosages> getDrugUsageById(@PathVariable long id){
        Optional<DrugDosages> found = drugDosagesService.getDrugDosagesById(id);
        return found.map(drugDosages -> new ResponseEntity<>(drugDosages, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "")
    ResponseEntity<DrugDosages> addDrugDosages(@RequestBody DrugDosages drugDosages){
        int i = drugDosagesService.addDrugDosages(drugDosages);
        if(i == 1){
            return new ResponseEntity<>(drugDosages, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping(path = "{id}")
    ResponseEntity<DrugDosages> updateDrugDosages(@PathVariable long id, @RequestBody DrugDosages drugDosages){
        int i = drugDosagesService.updateDrugDosages(id, drugDosages);
        if(i == 1){
            return new ResponseEntity<>(drugDosages, HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "{id}")
    ResponseEntity<DrugDosages> deleteDrugDosages(@PathVariable long id){
        int i = drugDosagesService.deleteDrugDosages(id);
        if(i == 1){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
