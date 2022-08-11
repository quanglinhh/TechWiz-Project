package com.example.backendv1.AppointmentStatus.Repository;

import com.example.backendv1.AppointmentStatus.Model.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatus, Long> {
}
