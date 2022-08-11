package com.example.backendv1.HealthInformationByDay.Service;

import com.example.backendv1.HealthInformationByDay.Model.HealthInformationByDay;
import com.example.backendv1.HealthInformationByDay.Repository.HealthInformationByDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthInformationByDayServiceImpl implements HealthInformationByDayService{
    @Autowired
    HealthInformationByDayRepository healthInformationByDayRepository;

    @Override
    public List<HealthInformationByDay> getAllHealthInformationByDay() {
        return healthInformationByDayRepository.findAllByOrderByIdAsc();
    }

    @Override
    public HealthInformationByDay saveHealthInformationByDay(HealthInformationByDay healthInformationByDay) {
        return healthInformationByDayRepository.save(healthInformationByDay);
    }

    @Override
    public void deleteHealthInformationByDay(Long id) {
        healthInformationByDayRepository.deleteById(id);
    }

    @Override
    public Optional<HealthInformationByDay> findHealthInformationByDayById(Long id) {
        return healthInformationByDayRepository.findById(id);
    }

    @Override
    public HealthInformationByDay getOne(Long id) {
        return healthInformationByDayRepository.findById(id).get();
    }

    @Override
    public List<HealthInformationByDay> getAllHealthInformationOrderByBloodPressureDesc() {
        return healthInformationByDayRepository.findAllByOrderByBloodPressureDesc();
    }

    @Override
    public List<HealthInformationByDay> getAllHealthInformationBOrderByBloodPressureAsc() {
        return healthInformationByDayRepository.findAllByOrderByBloodPressureAsc();
    }

    @Override
    public List<HealthInformationByDay> getAllHealthInformationOrderByWeightAsc() {
        return healthInformationByDayRepository.findAllByOrderByWeightAsc();
    }

    @Override
    public List<HealthInformationByDay> getAllHealthInformationOrderByWeightDesc() {
        return healthInformationByDayRepository.findAllByOrderByWeightDesc();
    }

    @Override
    public List<HealthInformationByDay> getAllHealthInformationOrderByGlucoseLevelAsc() {
        return healthInformationByDayRepository.findAllByOrderByGlucoseLevelAsc();
    }

    @Override
    public List<HealthInformationByDay> getAllHealthInformationBOrderByGlucoseLevelDesc() {
        return healthInformationByDayRepository.findAllByOrderByGlucoseLevelDesc();
    }

    @Override
    public List<HealthInformationByDay> getAllHealthInformationOrderByBloodTypeAsc() {
        return healthInformationByDayRepository.findAllByOrderByBloodTypeAsc();
    }

    @Override
    public List<HealthInformationByDay> getAllHealthInformationOrderByBloodTypeDesc() {
        return healthInformationByDayRepository.findAllByOrderByBloodTypeDesc();
    }

    @Override
    public List<HealthInformationByDay> findHealthInformationByBloodPressure(String bloodPressure) {
        return healthInformationByDayRepository.findHealthInformationByBloodPressure(bloodPressure);
    }

    @Override
    public List<HealthInformationByDay> findHealthInformationByWeight(double weight) {
        return healthInformationByDayRepository.findHealthInformationByWeight(weight);
    }

    @Override
    public List<HealthInformationByDay> findHealthInformationByBloodType(String bloodType) {
        return healthInformationByDayRepository.findHealthInformationByBloodType(bloodType);
    }

    @Override
    public List<HealthInformationByDay> findHealthInformationByGlucoseLevel(int glucoseLevel) {
        return healthInformationByDayRepository.findHealthInformationByGlucoseLevel(glucoseLevel);
    }


}
