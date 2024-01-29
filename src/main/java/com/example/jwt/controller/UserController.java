package com.example.jwt.controller;

import com.example.jwt.entity.Role;
import com.example.jwt.entity.User;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostConstruct
    public void initRolesAndAdmin(){
        userService.initRolesAndAdmin();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);

    }
}
