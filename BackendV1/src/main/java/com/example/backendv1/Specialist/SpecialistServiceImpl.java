package com.example.backendv1.Specialist;

import com.example.backendv1.Doctor.DoctorRepository;
import com.example.backendv1.Doctor.DoctorService;
import com.example.backendv1.Doctor.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SpecialistServiceImpl implements SpecialistService {
    @Autowired
    private SpecialistRepository speciaListRepo;
    @Override
    public List<Specialists> getAllSpecialist() {
        return speciaListRepo.findAll();
    }

    @Override
    public Optional<Specialists> getSpecialistById(Long id) {
        return speciaListRepo.findById(id);
    }

    @Override
    public void addSpecialist(Specialists specialist) {
        speciaListRepo.save(specialist);
    }

    @Override
    public boolean deleteSpecialist(Long id) {
        Optional<Specialists> speciaList = speciaListRepo.findById(id);
        if (speciaList.isPresent()) {
            speciaListRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Specialists updateSpecialist(Long id, Specialists specialist) {
        Optional<Specialists> oldSpeciaList = speciaListRepo.findById(id);
        if (oldSpeciaList.isPresent()){
            Specialists _oldSpeciaList = oldSpeciaList.get();
            _oldSpeciaList.setName(specialist.getName());
            return speciaListRepo.save(_oldSpeciaList);
        }
        return null;
    }
}
