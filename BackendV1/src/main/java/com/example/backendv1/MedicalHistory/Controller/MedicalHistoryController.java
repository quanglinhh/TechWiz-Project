package com.example.backendv1.MedicalHistory.Controller;
import com.example.backendv1.MedicalHistory.Model.MedicalHistory;
import com.example.backendv1.MedicalHistory.Service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "medical-history")
public class MedicalHistoryController {
    @Autowired
    MedicalHistoryService medicalHistoryService;

    @GetMapping(path = {"", "/page/{pageNo}"})
    ResponseEntity<Page<MedicalHistory>> getAllMedicalHistory(@PathVariable(required = false) Integer pageNo){
        int pageSize = 20;
        Page<MedicalHistory> allMedicalHistory;
        if(pageNo != null) {
            allMedicalHistory = medicalHistoryService.getAllMedicalHistory(pageNo, pageSize);
        } else {
            allMedicalHistory = medicalHistoryService.getAllMedicalHistory(1, pageSize);
        }
        if(!allMedicalHistory.isEmpty()){
            return new ResponseEntity<>(allMedicalHistory, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    ResponseEntity<MedicalHistory> addMedicalHistory(@RequestBody MedicalHistory medicalHistory){
        int i = medicalHistoryService.addMedicalHistory(medicalHistory);
        if(i == 1){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping(path = "{id}")
    ResponseEntity<MedicalHistory> updateMedicalHistory(@PathVariable long id, @RequestBody MedicalHistory medicalHistory){
        int i = medicalHistoryService.updateMedicalHistory(id, medicalHistory);
        if(i == 1){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "{id}")
    ResponseEntity<MedicalHistory> deleteMedicalHistory(@PathVariable long id){
        int i = medicalHistoryService.deleteMedicalHistory(id);
        if(i == 1){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
