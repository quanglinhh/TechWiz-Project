package com.example.backendv1.AppointmentSchedules.Service;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<AppointmentSchedules> listAll();

    AppointmentSchedules save (AppointmentSchedules appointmentSchedules);

    Optional<AppointmentSchedules> findById(Long id);

    void deleteById(Long id);
}
