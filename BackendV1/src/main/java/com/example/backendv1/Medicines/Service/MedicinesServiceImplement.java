package com.example.backendv1.Medicines.Service;

import com.example.backendv1.Medicines.Model.Medicines;
import com.example.backendv1.Medicines.Repository.RepositoryMedicines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicinesServiceImplement implements MedicinesService{
    @Autowired
    RepositoryMedicines repositoryMedicines;
    @Override
    public int countMedicine() {
        return repositoryMedicines.countList();

    }
    @Override
    public List<Medicines> getAllMedicines() {
        return repositoryMedicines.findAll();
    }

    @Override
    public Page<Medicines> getAllMedicinesByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return repositoryMedicines.findAll(pageable);
    }

    @Override
    public Optional<Medicines> getMedicinesById(long id) {
        return repositoryMedicines.findById(id);
    }

    @Override
    public int addMedicines(Medicines medicines) {
        List<Medicines> all = repositoryMedicines.findAll();
        if(!all.contains(medicines)){
            repositoryMedicines.save(medicines);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateMedicines(long id, Medicines medicines) {
        Optional<Medicines> found = repositoryMedicines.findById(id);
        if(found.isPresent()){
            found.get().setName(medicines.getName());
            found.get().setNote(medicines.getNote());
            repositoryMedicines.save(medicines);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteMedicines(long id) {
        Optional<Medicines> found = repositoryMedicines.findById(id);
        if(found.isPresent()){
            repositoryMedicines.delete(found.get());
            return 1;
        }
        return 0;
    }
}
