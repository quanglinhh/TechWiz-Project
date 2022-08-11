package com.example.backendv1.AppointmentSchedules.Service;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.example.backendv1.AppointmentSchedules.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentSchedules> listAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public AppointmentSchedules save(AppointmentSchedules appointmentSchedules) {
        return appointmentRepository.save(appointmentSchedules);
    }

    @Override
    public Optional<AppointmentSchedules> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
