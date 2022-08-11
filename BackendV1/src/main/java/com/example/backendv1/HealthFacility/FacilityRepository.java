package com.example.backendv1.HealthFacility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<HealthFacilities,Long> {

}
