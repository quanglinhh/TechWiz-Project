package com.example.backendv1.MedicalHistory.Service;
import com.example.backendv1.MedicalHistory.Model.MedicalHistory;
import com.example.backendv1.MedicalHistory.Repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService{
    @Autowired
    MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public List<MedicalHistory> getAllMedicalHistory() {
        return medicalHistoryRepository.findAll();
    }

    @Override
    public Page<MedicalHistory> getAllMedicalHistory(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return medicalHistoryRepository.findAll(pageable);
    }

    @Override
    public Optional<MedicalHistory> getMedicalHistoryById(long id) {
        return medicalHistoryRepository.findById(id);
    }

    @Override
    public int addMedicalHistory(MedicalHistory medicalHistory) {
        List<MedicalHistory> allMedicalHistory = medicalHistoryRepository.findAll();
        if(!allMedicalHistory.contains(medicalHistory)){
            medicalHistoryRepository.save(medicalHistory);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateMedicalHistory(long id, MedicalHistory medicalHistory) {
        Optional<MedicalHistory> found = medicalHistoryRepository.findById(id);
        if(found.isPresent()){
            found.get().setMedicalRecord(medicalHistory.getMedicalRecord());
            found.get().setAllergy(medicalHistory.getAllergy());
            medicalHistoryRepository.save(found.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteMedicalHistory(long id) {
        Optional<MedicalHistory> found = medicalHistoryRepository.findById(id);
        if(found.isPresent()){
            medicalHistoryRepository.delete(found.get());
            return 1;
        }
        return 0;
    }
}
