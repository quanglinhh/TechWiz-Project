package com.example.backendv1.UserRole.Model.Medicines.Service;

import com.example.backendv1.UserRole.Model.Medicines.Model.Medicines;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MedicinesService {
    public List<Medicines> getAllMedicines();
    public Page<Medicines> getAllMedicinesByPage(int pageNo, int pageSize);
    public Optional<Medicines> getMedicinesById(long id);
    public int addMedicines(Medicines medicines);
    public int updateMedicines(long id, Medicines medicines);
    public int deleteMedicines(long id);
}
