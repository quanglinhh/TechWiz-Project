package com.example.backendv1.HealthFacility;

import com.example.backendv1.Specialist.Specialists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/facility")
public class FacilityController {
    @Autowired
    FacilityService facilityService;
    @GetMapping("/get-all")
    public ResponseEntity<List<HealthFacilities>> getAllFacility(){
        List<HealthFacilities> healthFacility = facilityService.getAllHealthFacility();
        if (healthFacility.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthFacilities>>(healthFacility, HttpStatus.OK);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<HealthFacilities> getFacilityById(@PathVariable("id") Long id){
        Optional<HealthFacilities> healthFacility = facilityService.getHealthFacilityById(id);
        if (healthFacility.isPresent()){
            return new ResponseEntity<>(healthFacility.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<HealthFacilities> addFacility (@RequestBody HealthFacilities healthFacility) {
        try {
            facilityService.addHealthFacility(healthFacility);
            return ResponseEntity.ok(healthFacility);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<HealthFacilities> deleteFacility(@RequestParam("id") long id) {
        boolean bl = facilityService.deleteHealthFacility(id);
        if (bl == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping ("/update")
    public ResponseEntity<HealthFacilities> updateFacility (@RequestParam("id") Long id,@RequestBody HealthFacilities healthFacility) {
        try {
            facilityService.updateHealthFacility(id,healthFacility);
            return ResponseEntity.ok(healthFacility);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}