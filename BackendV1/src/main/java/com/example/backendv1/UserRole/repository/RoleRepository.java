package com.example.backendv1.UserRole.repository;

import com.example.backendv1.UserRole.Model.Roles;
import com.example.backendv1.UserRole.Model.UserRoles;
import com.example.backendv1.UserRole.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Short> {
    Roles findByName(String name);
}
