package com.example.jwt.repository;

import com.example.jwt.entity.Role;
import com.example.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUserName(String userName);
}
