package com.example.backendv1.DrugDosages.Repository;

import com.example.backendv1.DrugDosages.Model.DrugDosages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugDosagesRepository extends JpaRepository<DrugDosages, Long> {
    Page<DrugDosages> findAll(Pageable pageable); //divide page
}
