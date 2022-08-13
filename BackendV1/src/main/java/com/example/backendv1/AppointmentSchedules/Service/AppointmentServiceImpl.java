package com.example.backendv1.AppointmentSchedules.Service;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.example.backendv1.AppointmentSchedules.Repository.AppointmentRepository;
import com.example.backendv1.UserRole.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
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
    public Page<AppointmentSchedules> listAllByPage(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        System.out.println("===================");
        System.out.println("===================");
        System.out.println("===================");
        System.out.println("===================");
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
    public boolean deleteById(Long id) {
        AppointmentSchedules appointmentSchedules = appointmentRepository.findById(id).get();
        Date dateNow = Date.from(Instant.now());
        if (((appointmentSchedules.getTime().getTime()) - (dateNow.getTime()) >=172800000)){
            appointmentRepository.deleteById(id);
            return true;
        }else {
           return false;
        }

    }

    @Override
    public List<AppointmentSchedules> findByUser(Users users) {
        return appointmentRepository.findByUser(users);
    }


}
