package com.example.backendv1.AppointmentSchedules.Controller;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.example.backendv1.AppointmentSchedules.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/get-all")
    public ResponseEntity<List<AppointmentSchedules>> index() {
        List<AppointmentSchedules> appointmentSchedulesLists = appointmentService.listAll();

        if(appointmentSchedulesLists.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<AppointmentSchedules>>(appointmentSchedulesLists, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AppointmentSchedules> save(
            @RequestBody AppointmentSchedules appointmentSchedules
    ) {
        try {
            appointmentService.save(appointmentSchedules);

            return ResponseEntity.ok(appointmentSchedules);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentSchedules> update(
            @PathVariable("id") Long id,
            @RequestBody AppointmentSchedules newAppointmentSchedules
    ) {

        AppointmentSchedules appointmentSchedules = appointmentService.findById(id).get();

        if(appointmentSchedules == null) {
            return ResponseEntity.notFound().build();
        }

        appointmentSchedules.setUserId(newAppointmentSchedules.getUserId());
        appointmentSchedules.setDoctorId(newAppointmentSchedules.getDoctorId());
        appointmentSchedules.setStatus(newAppointmentSchedules.getStatus());
        appointmentSchedules.setTime(newAppointmentSchedules.getTime());
        appointmentSchedules.setCreatedAt(newAppointmentSchedules.getCreatedAt());
        appointmentSchedules.setUpdatedAt(newAppointmentSchedules.getUpdatedAt());

        appointmentService.save(appointmentSchedules);
        return ResponseEntity.ok(appointmentSchedules);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<AppointmentSchedules> delete(
            @PathVariable(value = "id") Long id
    ) {
        AppointmentSchedules appointmentSchedules = appointmentService.findById(id).get();

        if(appointmentSchedules == null) {
            return ResponseEntity.notFound().build();
        }

        appointmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
