package com.example.backendv1.AppointmentSchedules.Service;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.example.backendv1.AppointmentSchedules.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<AppointmentSchedules> listAllByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return appointmentRepository.findAll(pageable);
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
