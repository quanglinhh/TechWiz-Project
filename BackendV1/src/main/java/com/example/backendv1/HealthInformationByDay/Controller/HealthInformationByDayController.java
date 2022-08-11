package com.example.backendv1.HealthInformationByDay.Controller;

import com.example.backendv1.HealthInformationByDay.Model.HealthInformationByDay;
import com.example.backendv1.HealthInformationByDay.Service.HealthInformationByDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class HealthInformationByDayController {
    @Autowired
    HealthInformationByDayService healthInformationByDayService;

    //Add
    @RequestMapping(value = "/healthInformation", method = RequestMethod.POST)
    public ResponseEntity<HealthInformationByDay> saveHealthInformationByDay (
            @RequestBody HealthInformationByDay healthInformationByDay){
        healthInformationByDayService.saveHealthInformationByDay(healthInformationByDay);
        return ResponseEntity.ok(healthInformationByDay);
    }

    //get all
    @RequestMapping(value = "/healthInformation", method = RequestMethod.GET)
    public ResponseEntity<List<HealthInformationByDay>> getAllHealthInformationByDay() {
        List<HealthInformationByDay> healthInformationByDays = healthInformationByDayService.getAllHealthInformationByDay();
        if (healthInformationByDays.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthInformationByDay>>(healthInformationByDays, HttpStatus.OK);
    }

    // get by id
    @RequestMapping(value = "/healthInformation/{id}", method = RequestMethod.GET)
    public ResponseEntity<HealthInformationByDay> getHealthInformationByDay(@PathVariable("id") Long id) {
        HealthInformationByDay healthInformationByDay = healthInformationByDayService.getOne(id);
        if (healthInformationByDay == null){
            System.out.println("Not found id: " + id);
        }
        return new ResponseEntity<HealthInformationByDay>(healthInformationByDay, HttpStatus.OK);
    }

    //update
    @RequestMapping(value = "/healthInformation/{id}", method = RequestMethod.PUT)
    public ResponseEntity<HealthInformationByDay> updateHealthInformationByDay(
            @PathVariable("id") Long id, @RequestBody HealthInformationByDay healthInformationByDay) {
         HealthInformationByDay oldHealthInformationByDay = healthInformationByDayService.getOne(id);
         if (oldHealthInformationByDay == null){
             return ResponseEntity.notFound().build();
         } else {
             oldHealthInformationByDay.setBloodPressure(healthInformationByDay.getBloodPressure());
             oldHealthInformationByDay.setWeight(healthInformationByDay.getWeight());
             oldHealthInformationByDay.setGlucoseLevel(healthInformationByDay.getGlucoseLevel());
             oldHealthInformationByDay.setBloodType(healthInformationByDay.getBloodType());
             oldHealthInformationByDay.setNote(healthInformationByDay.getNote());
             oldHealthInformationByDay.setCreatedAt(healthInformationByDay.getCreatedAt());
             oldHealthInformationByDay.setUpdatedAt(healthInformationByDay.getUpdatedAt());
         }

         healthInformationByDay = healthInformationByDayService.saveHealthInformationByDay(oldHealthInformationByDay);
         return ResponseEntity.ok(oldHealthInformationByDay);
    }

    //delete
    @RequestMapping(value = "/healthInformation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HealthInformationByDay> deleteHealthInformationByDay(@PathVariable("id") Long id){
        Optional<HealthInformationByDay> healthInformationByDay = healthInformationByDayService.findHealthInformationByDayById(id);
        if (!healthInformationByDay.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            healthInformationByDayService.deleteHealthInformationByDay(id);
            return ResponseEntity.ok().build();
        }
    }

    //search by bloodPressure
    @RequestMapping(value = "/healthInformation/bloodPressure", method = RequestMethod.GET)
    public ResponseEntity<List<HealthInformationByDay>> getHealthInformationByBloodPressure(@RequestParam("bloodPressure") String bloodPressure) {
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.findHealthInformationByBloodPressure(bloodPressure);

        return new ResponseEntity <List<HealthInformationByDay>>(healthInformationByDays, HttpStatus.OK);
    }

    //search by weight
    @RequestMapping(value = "/healthInformation/weight", method = RequestMethod.GET)
    public ResponseEntity<List<HealthInformationByDay>> getHealthInformationByWeight(@RequestParam("bloodPressure") double weight) {
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.findHealthInformationByWeight(weight);

        return new ResponseEntity <List<HealthInformationByDay>>(healthInformationByDays, HttpStatus.OK);
    }

    //search by glucoseLevel
    @RequestMapping(value = "/healthInformation/glucoseLevel", method = RequestMethod.GET)
    public ResponseEntity<List<HealthInformationByDay>> getHealthInformationByGlucoseLevel(@RequestParam("glucoseLevel") int glucoseLevel) {
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.findHealthInformationByGlucoseLevel(glucoseLevel);

        return new ResponseEntity <List<HealthInformationByDay>>(healthInformationByDays, HttpStatus.OK);
    }

    //search by bloodPressure
    @RequestMapping(value = "/healthInformation/bloodType", method = RequestMethod.GET)
    public ResponseEntity<List<HealthInformationByDay>> getHealthInformationByBloodType(@RequestParam("bloodType") String bloodType) {
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.findHealthInformationByBloodType(bloodType);

        return new ResponseEntity <List<HealthInformationByDay>>(healthInformationByDays, HttpStatus.OK);
    }

    // get all by bloodPressure asc
    @RequestMapping(value = "/healthInformation/bloodPressureAsc", method = RequestMethod.GET)
    public ResponseEntity getAllByBloodPressureAsc(){
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.getAllHealthInformationBOrderByBloodPressureAsc();
        if (healthInformationByDays.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthInformationByDay>>(healthInformationByDays,HttpStatus.OK);
    }

    // get all by bloodPressure desc
    @RequestMapping(value = "/healthInformation/bloodPressureDesc", method = RequestMethod.GET)
    public ResponseEntity getAllByBloodPressureDesc(){
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.getAllHealthInformationOrderByBloodPressureDesc();
        if (healthInformationByDays.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthInformationByDay>>(healthInformationByDays,HttpStatus.OK);
    }

    // get all by weight asc
    @RequestMapping(value = "/healthInformation/weightAsc", method = RequestMethod.GET)
    public ResponseEntity getAllByWeightAsc(){
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.getAllHealthInformationOrderByWeightAsc();
        if (healthInformationByDays.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthInformationByDay>>(healthInformationByDays,HttpStatus.OK);
    }

    // get all by weight desc
    @RequestMapping(value = "/healthInformation/weightDesc", method = RequestMethod.GET)
    public ResponseEntity getAllByWeightDesc(){
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.getAllHealthInformationOrderByWeightDesc();
        if (healthInformationByDays.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthInformationByDay>>(healthInformationByDays,HttpStatus.OK);
    }

    // get all by glucoseLevel asc
    @RequestMapping(value = "/healthInformation/glucoseLevelAsc", method = RequestMethod.GET)
    public ResponseEntity getAllByGlucoseLevelAsc(){
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.getAllHealthInformationOrderByGlucoseLevelAsc();
        if (healthInformationByDays.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthInformationByDay>>(healthInformationByDays,HttpStatus.OK);
    }

    // get all by glucoseLevel desc
    @RequestMapping(value = "/healthInformation/glucoseLevelDesc", method = RequestMethod.GET)
    public ResponseEntity getAllByGlucoseLevelDesc(){
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.getAllHealthInformationBOrderByGlucoseLevelDesc();
        if (healthInformationByDays.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthInformationByDay>>(healthInformationByDays,HttpStatus.OK);
    }

    // get all by bloodType asc
    @RequestMapping(value = "/healthInformation/bloodTypeAsc", method = RequestMethod.GET)
    public ResponseEntity getAllByBloodTypeAsc(){
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.getAllHealthInformationOrderByBloodTypeAsc();
        if (healthInformationByDays.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthInformationByDay>>(healthInformationByDays,HttpStatus.OK);
    }

    // get all by bloodType desc
    @RequestMapping(value = "/healthInformation/bloodTypeDesc", method = RequestMethod.GET)
    public ResponseEntity getAllByBloodTypeDesc(){
        List<HealthInformationByDay> healthInformationByDays
                = healthInformationByDayService.getAllHealthInformationOrderByBloodTypeDesc();
        if (healthInformationByDays.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HealthInformationByDay>>(healthInformationByDays,HttpStatus.OK);
    }
}
