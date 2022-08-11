package com.example.backendv1.AppointmentSchedules.Repository;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentSchedules, Long> {
    Page<AppointmentSchedules> findAll(Pageable pageable);
}
