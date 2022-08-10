package com.example.backendv1.HealthInformationByDay.Service;

import com.example.backendv1.DrugDosages.Model.DrugDosages;
import com.example.backendv1.HealthInformationByDay.Model.HealthInformationByDay;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface HealthInformationByDayService {

    List<HealthInformationByDay> getAllHealthInformationByDay();

    HealthInformationByDay saveHealthInformationByDay(HealthInformationByDay healthInformationByDay);

    void deleteHealthInformationByDay(Long id);

    Optional<HealthInformationByDay> findHealthInformationByDayById(Long id);

    public HealthInformationByDay getOne(Long id);

    List<HealthInformationByDay> getAllHealthInformationOrderByBloodPressureDesc();

    List<HealthInformationByDay> getAllHealthInformationBOrderByBloodPressureAsc();

    List<HealthInformationByDay> getAllHealthInformationOrderByWeightAsc();
    List<HealthInformationByDay> getAllHealthInformationOrderByWeightDesc();

    List<HealthInformationByDay> getAllHealthInformationOrderByGlucoseLevelAsc();
    List<HealthInformationByDay> getAllHealthInformationBOrderByGlucoseLevelDesc();

    List<HealthInformationByDay> getAllHealthInformationOrderByBloodTypeAsc();
    List<HealthInformationByDay> getAllHealthInformationOrderByBloodTypeDesc();

    public List<HealthInformationByDay> findHealthInformationByBloodPressure(String bloodPressure);
    public List<HealthInformationByDay> findHealthInformationByWeight(double weight);

    public List<HealthInformationByDay> findHealthInformationByGlucoseLevel(int glucoseLevel);
    public List<HealthInformationByDay> findHealthInformationByBloodType(String bloodType);


}
