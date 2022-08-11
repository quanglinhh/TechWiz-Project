package com.example.backendv1.AppointmentStatus.Controller;
import com.example.backendv1.AppointmentStatus.Model.AppointmentStatus;
import com.example.backendv1.AppointmentStatus.Service.AppointmentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointment-status")
public class AppointmentStatusController {
    @Autowired
    AppointmentStatusService appointmentStatusService;

    @GetMapping("/get-all")
    public ResponseEntity<List<AppointmentStatus>> index() {
        List<AppointmentStatus> appointmentStatusLists = appointmentStatusService.listAll();

        if(appointmentStatusLists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appointmentStatusLists, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AppointmentStatus> save(
            @RequestBody AppointmentStatus appointmentStatus
    ) {
        appointmentStatusService.save(appointmentStatus);
        return ResponseEntity.ok(appointmentStatus);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentStatus> update(
            @PathVariable("id") Long id,
            @RequestBody AppointmentStatus newAppointmentStatus
    ) {

        AppointmentStatus appointmentStatus = appointmentStatusService.findById(id).get();

        if(appointmentStatus == null) {
            return ResponseEntity.notFound().build();
        }
        appointmentStatus.setName(newAppointmentStatus.getName());

        appointmentStatusService.save(appointmentStatus);
        return ResponseEntity.ok(appointmentStatus);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<AppointmentStatus> delete(
            @PathVariable("id") Long id
    ) {
        AppointmentStatus appointmentStatus = appointmentStatusService.findById(id).get();

        if(appointmentStatus == null) {
            return ResponseEntity.notFound().build();
        }

        appointmentStatusService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
