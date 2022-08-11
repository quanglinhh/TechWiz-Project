package com.example.backendv1.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public List<Doctors> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public Page<Doctors> getAllDoctor(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return doctorRepository.findAll(pageable);
    }

    @Override
    public Optional<Doctors> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }
    @Override
    public void addDoctor(Doctors doctor) {
        doctorRepository.save(doctor);
    }
    @Override
    public boolean deleteDoctor(Long id) {
        Optional<Doctors> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Doctors updateDoctor(Long id, Doctors doctor) {
        Optional<Doctors> oldDoctor = doctorRepository.findById(id);
        if (oldDoctor.isPresent()){
            Doctors _oldDoctor = oldDoctor.get();
            _oldDoctor.setName(doctor.getName());
            _oldDoctor.setSpecialists(doctor.getSpecialists());
            _oldDoctor.setImage(doctor.getImage());
            _oldDoctor.setAddress(doctor.getAddress());
            _oldDoctor.setPhone(doctor.getPhone());
            _oldDoctor.setHealthFacilities(doctor.getHealthFacilities());
            _oldDoctor.setGender(doctor.getGender());
            return doctorRepository.save(_oldDoctor);
        }
        return null;
    }
}
