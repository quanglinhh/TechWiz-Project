package com.example.backendv1.MedicalHistory.Repository;

import com.example.backendv1.MedicalHistory.Model.MedicalHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
    Page<MedicalHistory> findAll(Pageable pageable);
}
