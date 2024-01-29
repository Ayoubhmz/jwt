package com.example.jwt.repository;

import com.example.jwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);

}
