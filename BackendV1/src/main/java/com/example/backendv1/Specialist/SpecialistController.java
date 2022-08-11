package com.example.backendv1.Specialist;

import com.example.backendv1.Doctor.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/specialist")
public class SpecialistController {
    @Autowired
    SpecialistService specialistService;
    @GetMapping("/get-all")
    public ResponseEntity<List<Specialists>> getAllSpecialist(){
        List<Specialists> specialist = specialistService.getAllSpecialist();
        if (specialist.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(specialist, HttpStatus.OK);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Specialists> getSpecialistById(@PathVariable("id") Long id){
        Optional<Specialists> specialist = specialistService.getSpecialistById(id);
        return specialist.map(specialists -> new ResponseEntity<>(specialists, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/add")
    public ResponseEntity<Specialists> addSpecialist (@RequestBody Specialists specialist) {
        try {
            specialistService.addSpecialist(specialist);
            return ResponseEntity.ok(specialist);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Specialists> deleteSpecialist(@RequestParam("id") long id) {
        boolean bl = specialistService.deleteSpecialist(id);
        if (bl) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping ("/update")
    public ResponseEntity<Specialists> updateSpecialist (@RequestParam("id") Long id,@RequestBody Specialists specialist) {
        try {
            specialistService.updateSpecialist(id,specialist);
            return ResponseEntity.ok(specialist);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}