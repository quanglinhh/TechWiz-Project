package com.example.backendv1.HealthFacility;


import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface FacilityService {
    List<HealthFacilities> getAllHealthFacility();

    //Luyen bo sung
    Page<HealthFacilities> getAllHealthFacilities(int pageNo, int pageSize);
    public Optional<HealthFacilities> getHealthFacilityById(Long id);
    int addHealthFacility(HealthFacilities healthFacility);
    int deleteHealthFacility(Long id);
    int updateHealthFacility (Long id, HealthFacilities healthFacility);
    HealthFacilities findFacilitiesIdByName(String name);

    List<HealthFacilities> finFacilityByAddress(String address);


}
