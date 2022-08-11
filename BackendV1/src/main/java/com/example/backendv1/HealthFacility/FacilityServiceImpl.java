package com.example.backendv1.HealthFacility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityRepository healthFacilityRepo;
    @Override
    public List<HealthFacilities> getAllHealthFacility() {
        return healthFacilityRepo.findAll();
    }

    @Override
    public Optional<HealthFacilities> getHealthFacilityById(Long id) {
        return healthFacilityRepo.findById(id);
    }

    @Override
    public void addHealthFacility(HealthFacilities healthFacility) {
        healthFacilityRepo.save(healthFacility);

    }

    @Override
    public boolean deleteHealthFacility(Long id) {
        Optional<HealthFacilities> healthFacility = healthFacilityRepo.findById(id);
        if (healthFacility.isPresent()) {
            healthFacilityRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public HealthFacilities updateHealthFacility(Long id, HealthFacilities healthFacility) {
        Optional<HealthFacilities> oldHealthFacility = healthFacilityRepo.findById(id);
        if (oldHealthFacility.isPresent()){
            HealthFacilities _oldHealthFacility = oldHealthFacility.get();
            _oldHealthFacility.setName(healthFacility.getName());
            _oldHealthFacility.setAddress(healthFacility.getAddress());
            _oldHealthFacility.setPhone(healthFacility.getPhone());
            _oldHealthFacility.setWebsite(healthFacility.getWebsite());
            return healthFacilityRepo.save(_oldHealthFacility);
        }
        return null;
    }
}
