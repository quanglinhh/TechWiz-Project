package com.example.backendv1.MedicalHistory.Service;

import com.example.backendv1.MedicalHistory.Model.MedicalHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MedicalHistoryService {
    List<MedicalHistory> getAllMedicalHistory();
    Page<MedicalHistory> getAllMedicalHistory(int pageNo, int pageSize);
    Optional<MedicalHistory> getMedicalHistoryById(long id);
    int addMedicalHistory(MedicalHistory medicalHistory);
    int updateMedicalHistory(long id, MedicalHistory medicalHistory);
    int deleteMedicalHistory(long id);
}
