package com.example.backendv1.DrugDosages.Service;

import com.example.backendv1.DrugDosages.Model.DrugDosages;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DrugDosagesService {
    public List<DrugDosages> getAllDrugDosages();
    public Page<DrugDosages> getAllDrugDosagesByPage(int pageNo, int pageSize);
    public Optional<DrugDosages> getDrugDosagesById(long id);
    public int addDrugDosages(DrugDosages drugDosages);
    public int updateDrugDosages(long id, DrugDosages drugDosages);
    public int deleteDrugDosages(long id);
}
