package com.example.backendv1.HealthFacility;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<HealthFacilities,Long> {
        Page<HealthFacilities> findAll(Pageable pageable);
        HealthFacilities findHealthFacilitiesByName(String name);
        List<HealthFacilities> findHealthFacilitiesByAddress(String address);
        @Query("SELECT count(id) FROM Specialists ")
        public int countList();



}
