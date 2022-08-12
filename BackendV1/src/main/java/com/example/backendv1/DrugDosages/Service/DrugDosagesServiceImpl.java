package com.example.backendv1.DrugDosages.Service;
import com.example.backendv1.DrugDosages.Model.DrugDosages;
import com.example.backendv1.DrugDosages.Repository.DrugDosagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DrugDosagesServiceImpl implements DrugDosagesService{
    @Autowired
    DrugDosagesRepository drugDosagesRepository;

    @Override
    public List<DrugDosages> getAllDrugDosages() {
        return drugDosagesRepository.findAll();
    }

    @Override
    public List<DrugDosages> getAllDrugDosagesByUserId(long id) {
        return drugDosagesRepository.findAll().stream().filter(s -> s.getUser().getId()== id).collect(Collectors.toList());
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
    public DrugDosages updateDrugDosages(long id, DrugDosages newDrugDosages) {



        DrugDosages found = drugDosagesRepository.findById(id).map(drug ->{
            drug.setTimePerDay(newDrugDosages.getTimePerDay());
            drug.setTimePerWeek(newDrugDosages.getTimePerWeek());
            drug.setQuantity(newDrugDosages.getQuantity());
            drug.setUpdatedAt( Date.from(Instant.now()));
            drugDosagesRepository.save(drug);
            return drugDosagesRepository.save(drug);
        }).orElseGet(()->{
            newDrugDosages.setId(id);
            return drugDosagesRepository.save(newDrugDosages);
        });
       return found;
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
