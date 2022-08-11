package com.example.backendv1.AppointmentSchedules.Controller;
import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.example.backendv1.AppointmentSchedules.Service.AppointmentService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@RequestMapping("api/v1/appointment")

public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping({"/get-all", "/get-all/{pageNo}"})
    public ResponseEntity<Page<AppointmentSchedules>> getAll(@PathVariable(required = false) Integer pageNo,
                                                             @RequestParam(value = "sortField", required = false) String sortField,
                                                             @RequestParam(value = "sortDir", required = false) String sortDir
                                                             )

    {
        int pageSize = 20;
        Page<AppointmentSchedules> appointmentSchedulesLists;
        if(pageNo != null && sortField != null && sortDir != null) {
            appointmentSchedulesLists = appointmentService.listAllByPage(pageNo, pageSize, sortField, sortDir);
        } else {
            appointmentSchedulesLists = appointmentService.listAllByPage(1, pageSize, "id", "desc");
        }

        if(appointmentSchedulesLists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appointmentSchedulesLists, HttpStatus.OK);
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
        Optional<AppointmentSchedules> appointmentSchedules = appointmentService.findById(id);
        if(appointmentSchedules.isPresent()){
            appointmentSchedules.get().setUser(newAppointmentSchedules.getUser());
            appointmentSchedules.get().setDoctor(newAppointmentSchedules.getDoctor());
            appointmentSchedules.get().setStatus(newAppointmentSchedules.getStatus());
            appointmentSchedules.get().setTime(newAppointmentSchedules.getTime());
            appointmentService.save(appointmentSchedules.get());
            return ResponseEntity.ok(appointmentSchedules.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<AppointmentSchedules> delete(
            @PathVariable(value = "id") Long id
    ) {
        Optional<AppointmentSchedules> appointmentSchedules = appointmentService.findById(id);

        if(appointmentSchedules.isPresent()) {
            appointmentService.deleteById(id);
            return ResponseEntity.notFound().build();
        }

        appointmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
