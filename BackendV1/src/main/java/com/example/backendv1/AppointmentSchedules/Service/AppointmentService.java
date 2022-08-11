package com.example.backendv1.AppointmentSchedules.Service;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<AppointmentSchedules> listAll();
    Page<AppointmentSchedules> listAllByPage(int pageNo, int pageSize);

    AppointmentSchedules save (AppointmentSchedules appointmentSchedules);

    Optional<AppointmentSchedules> findById(Long id);

    void deleteById(Long id);
}
