package com.example.jwt.controller;

import com.example.jwt.entity.Role;
import com.example.jwt.entity.User;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "this URL is only accessible to admin";
    }

    @GetMapping({"/forUser"})
    public String forUser(){
        return "this URL is only accessible to the user";
    }

}
