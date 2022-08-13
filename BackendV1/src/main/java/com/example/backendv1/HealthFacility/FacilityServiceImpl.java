package com.example.backendv1.HealthFacility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<HealthFacilities> getAllHealthFacilities(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return healthFacilityRepo.findAll(pageable);
    }

    @Override
    public Optional<HealthFacilities> getHealthFacilityById(Long id) {
        return healthFacilityRepo.findById(id);
    }

    @Override
    public int addHealthFacility(HealthFacilities healthFacility) {
        List<HealthFacilities> all = healthFacilityRepo.findAll();
        if(!all.contains(healthFacility)){
            healthFacilityRepo.save(healthFacility);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteHealthFacility(Long id) {
        Optional<HealthFacilities> healthFacility = healthFacilityRepo.findById(id);
        if (healthFacility.isPresent()) {
            healthFacilityRepo.delete(healthFacility.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateHealthFacility(Long id, HealthFacilities healthFacility) {
        Optional<HealthFacilities> oldHealthFacility = healthFacilityRepo.findById(id);
        if (oldHealthFacility.isPresent()){
            HealthFacilities _oldHealthFacility = oldHealthFacility.get();
            _oldHealthFacility.setName(healthFacility.getName());
            _oldHealthFacility.setAddress(healthFacility.getAddress());
            _oldHealthFacility.setPhone(healthFacility.getPhone());
            _oldHealthFacility.setWebsite(healthFacility.getWebsite());
            healthFacilityRepo.save(_oldHealthFacility);
            return 1;
        }
        return 0;
    }

    @Override
    public HealthFacilities findFacilitiesByName(String name) {
        HealthFacilities facility = healthFacilityRepo.findHealthFacilitiesByName(name);
        return facility;
    }

    @Override
    public List<HealthFacilities> finFacilityByAddress(String address) {
        List<HealthFacilities> facility = healthFacilityRepo.findHealthFacilitiesByAddress(address);
        return facility;
    }

}
