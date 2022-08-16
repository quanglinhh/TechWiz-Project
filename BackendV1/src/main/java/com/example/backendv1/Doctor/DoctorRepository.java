package com.example.backendv1.Doctor;

import com.example.backendv1.HealthFacility.HealthFacilities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctors,Long> {
    Page<Doctors> findAll(Pageable pageable);
    List<Doctors> findAllByHealthFacilities(HealthFacilities facility);

    Doctors findByName(String name);
    @Query("SELECT count(id) FROM Doctors ")
    public int countList();
}
