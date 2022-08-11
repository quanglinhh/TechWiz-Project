package com.example.backendv1.Doctor;


import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctors> getAllDoctor();
    Page<Doctors> getAllDoctor(int pageNo, int pageSize);
    public Optional<Doctors> getDoctorById(Long id);
    void addDoctor(Doctors doctor);
    public boolean  deleteDoctor(Long id);
    public Doctors updateDoctor(Long id, Doctors doctor);
}
