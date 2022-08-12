package com.example.backendv1.HealthInformationByDay.Repository;

import com.example.backendv1.HealthInformationByDay.Model.HealthInformationByDay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthInformationByDayRepository extends JpaRepository<HealthInformationByDay, Long> {
//    Page<HealthInformationByDay> findAll(Pageable pageable);

    public List<HealthInformationByDay> findAllByOrderByIdAsc();

    public List<HealthInformationByDay> findAllByOrderByBloodPressureAsc();
    public List<HealthInformationByDay> findAllByOrderByBloodPressureDesc();
    public List<HealthInformationByDay> findHealthInformationByBloodPressure(String bloodPressure);

    public List<HealthInformationByDay> findAllByOrderByWeightAsc();
    public List<HealthInformationByDay> findAllByOrderByWeightDesc();
    public List<HealthInformationByDay> findHealthInformationByWeight(double weight);

    public List<HealthInformationByDay> findAllByOrderByGlucoseLevelAsc();
    public List<HealthInformationByDay> findAllByOrderByGlucoseLevelDesc();
    public List<HealthInformationByDay> findHealthInformationByGlucoseLevel(int glucoseLevel);

    public List<HealthInformationByDay> findAllByOrderByBloodTypeAsc();
    public List<HealthInformationByDay> findAllByOrderByBloodTypeDesc();
    public List<HealthInformationByDay> findHealthInformationByBloodType(String bloodType);


    @Query("select count(h) from HealthInformationByDay h where h.id = ?1")
    Long countById();

}
