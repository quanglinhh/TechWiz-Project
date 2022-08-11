package com.example.backendv1.AppointmentStatus.Service;

import com.example.backendv1.AppointmentStatus.Model.AppointmentStatus;

import java.util.List;
import java.util.Optional;

public interface AppointmentStatusService {
    List<AppointmentStatus> listAll();

    AppointmentStatus save (AppointmentStatus appointmentStatus);

    Optional<AppointmentStatus> findById(Long id);

    void deleteById(Long id);
}
