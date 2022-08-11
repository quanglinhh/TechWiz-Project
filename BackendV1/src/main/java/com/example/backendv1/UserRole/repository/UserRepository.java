package com.example.backendv1.UserRole.repository;

import com.example.backendv1.UserRole.Model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Page<Users> findAll(Pageable pageable);
}
