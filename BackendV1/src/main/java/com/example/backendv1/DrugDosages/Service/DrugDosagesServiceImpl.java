package com.example.backendv1.DrugDosages.Service;
import com.example.backendv1.DrugDosages.Model.DrugDosages;
import com.example.backendv1.DrugDosages.Repository.DrugDosagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DrugDosagesServiceImpl implements DrugDosagesService{
    @Autowired
    DrugDosagesRepository drugDosagesRepository;

    @Override
    public List<DrugDosages> getAllDrugDosages() {
        return drugDosagesRepository.findAll();
    }

    @Override
    public Page<DrugDosages> getAllDrugDosagesByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return drugDosagesRepository.findAll(pageable);
    }

    @Override
    public Optional<DrugDosages> getDrugDosagesById(long id) {
        return drugDosagesRepository.findById(id);
    }

    @Override
    public int addDrugDosages(DrugDosages drugDosages) {
        List<DrugDosages> all = drugDosagesRepository.findAll();
        if(!all.contains(drugDosages)){
            drugDosagesRepository.save(drugDosages);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateDrugDosages(long id, DrugDosages drugDosages) {
        Optional<DrugDosages> found = drugDosagesRepository.findById(id);
        if(found.isPresent()){
            found.get().setQuantity(drugDosages.getQuantity());
            found.get().setTimePerDay(drugDosages.getTimePerDay());
            found.get().setTimePerWeek(drugDosages.getTimePerWeek());
            drugDosagesRepository.save(drugDosages);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteDrugDosages(long id) {
        Optional<DrugDosages> found = drugDosagesRepository.findById(id);
        if(found.isPresent()){
            drugDosagesRepository.delete(found.get());
            return 1;
        }
        return 0;
    }
}
