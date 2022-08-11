package com.example.backendv1.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
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
            _oldDoctor.setSpecialityId(doctor.getSpecialityId());
            _oldDoctor.setImage(doctor.getImage());
            _oldDoctor.setAddress(doctor.getAddress());
            _oldDoctor.setPhone(doctor.getPhone());
            _oldDoctor.setHealthFacilitiesId(doctor.getHealthFacilitiesId());
            _oldDoctor.setGender(doctor.getGender());
            return doctorRepository.save(_oldDoctor);
        }
        return null;
    }
}
