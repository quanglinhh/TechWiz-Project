package com.example.backendv1.UserRole.repository;

import com.example.backendv1.UserRole.Model.UserRoles;
import com.example.backendv1.UserRole.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles,Long> {
    UserRoles findByUsersByUserId(Users users);

    void deleteByUsersByUserId(Users users);
}
