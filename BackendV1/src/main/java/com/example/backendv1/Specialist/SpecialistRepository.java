package com.example.backendv1.Specialist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialists,Long> {
    @Query("SELECT count(id) FROM Specialists ")
    public int countList();
}
