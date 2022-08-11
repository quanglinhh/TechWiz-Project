package com.example.backendv1.AppointmentStatus.Service;

import com.example.backendv1.AppointmentStatus.Model.AppointmentStatus;
import com.example.backendv1.AppointmentStatus.Repository.AppointmentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentStatusServiceImpl implements AppointmentStatusService{
    @Autowired
    AppointmentStatusRepository appointmentStatusRepository;

    @Override
    public List<AppointmentStatus> listAll() {
        return appointmentStatusRepository.findAll();
    }

    @Override
    public AppointmentStatus save(AppointmentStatus appointmentStatus) {
        return appointmentStatusRepository.save(appointmentStatus);
    }

    @Override
    public Optional<AppointmentStatus> findById(Long id) {
        return appointmentStatusRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        appointmentStatusRepository.deleteById(id);
    }
}
