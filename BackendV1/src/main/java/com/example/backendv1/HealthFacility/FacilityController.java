package com.example.backendv1.HealthFacility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/facility")
public class FacilityController {
    @Autowired
    FacilityService facilityService;

    @GetMapping({"", "/{pageNo}"})
    public ResponseEntity<Page<HealthFacilities>> getAllFacility(@PathVariable(required = false) Integer pageNo) {
        Page<HealthFacilities> listByPage;
        int pageSize = 20;
        if (pageNo != null) {
            listByPage = facilityService.getAllHealthFacilities(pageNo, pageSize);
        } else {
            listByPage = facilityService.getAllHealthFacilities(1, pageSize);
        }
        if (listByPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listByPage, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<HealthFacilities> getFacilityById(@PathVariable("id") Long id) {
        Optional<HealthFacilities> healthFacility = facilityService.getHealthFacilityById(id);
        return healthFacility.map(healthFacilities -> new ResponseEntity<>(healthFacilities, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<HealthFacilities> addFacility(@RequestBody HealthFacilities healthFacility) {
        int i = facilityService.addHealthFacility(healthFacility);
        if (i == 1) {
            return ResponseEntity.ok(healthFacility);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HealthFacilities> deleteFacility(@RequestParam("id") long id) {
        int i = facilityService.deleteHealthFacility(id);
        if (i == 1) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HealthFacilities> updateFacility(@RequestParam("id") Long id, @RequestBody HealthFacilities healthFacility) {
        int i = facilityService.updateHealthFacility(id, healthFacility);
        if (i == 1) {
            return ResponseEntity.ok(healthFacility);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}