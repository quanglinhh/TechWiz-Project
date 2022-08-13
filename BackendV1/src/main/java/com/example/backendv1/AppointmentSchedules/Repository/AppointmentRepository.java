package com.example.backendv1.AppointmentSchedules.Repository;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.example.backendv1.UserRole.Model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentSchedules, Long> {
    Page<AppointmentSchedules> findAll(Pageable pageable);
    List<AppointmentSchedules> findByUser(Users users);
    List<AppointmentSchedules> findAllByOrderByTime();

}
