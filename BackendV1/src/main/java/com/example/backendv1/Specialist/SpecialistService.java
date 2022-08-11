package com.example.backendv1.Specialist;


import com.example.backendv1.Doctor.Doctors;

import java.util.List;
import java.util.Optional;

public interface SpecialistService {
    List<Specialists> getAllSpecialist();
    public Optional<Specialists> getSpecialistById(Long id);
    void addSpecialist(Specialists specialist);
    public boolean  deleteSpecialist(Long id);
    public Specialists updateSpecialist (Long id, Specialists specialist);
}
