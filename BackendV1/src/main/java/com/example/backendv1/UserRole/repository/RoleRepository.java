package com.example.backendv1.UserRole.repository;

import com.example.backendv1.UserRole.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Short> {

}
