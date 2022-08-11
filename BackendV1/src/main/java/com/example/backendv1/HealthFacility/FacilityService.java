package com.example.backendv1.HealthFacility;


import java.util.List;
import java.util.Optional;

public interface FacilityService {
    List<HealthFacilities> getAllHealthFacility();
    public Optional<HealthFacilities> getHealthFacilityById(Long id);
    void addHealthFacility(HealthFacilities healthFacility);
    public boolean  deleteHealthFacility(Long id);
    public HealthFacilities updateHealthFacility (Long id, HealthFacilities healthFacility);
}
