package com.example.backendv1.MedicalHistory.Specialist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialists,Long> {

}
