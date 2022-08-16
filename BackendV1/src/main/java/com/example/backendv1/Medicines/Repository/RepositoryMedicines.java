package com.example.backendv1.Medicines.Repository;

import com.example.backendv1.Medicines.Model.Medicines;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMedicines extends JpaRepository<Medicines, Long> {
    Page<Medicines> findAll(Pageable pageable);
    @Query("SELECT count(id) FROM Medicines ")
    public int countList();
}
