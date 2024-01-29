package com.example.jwt.service;

import com.example.jwt.dao.RoleDao;
import com.example.jwt.dao.UserDao;
import com.example.jwt.entity.Role;
import com.example.jwt.entity.User;
import com.example.jwt.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    RoleRepo roleRepo;

    //registering new user with "User" role by default
    public User registerNewUser(User user){
        Role DefaultRole = roleRepo.findByRoleName("User");
        Set<Role> Roles = new HashSet<>();
        Roles.add(DefaultRole);
        user.setRole(Roles);
        return userDao.save(user);
    }

    //initialization of roles and Admin
    public void initRolesAndAdmin (){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleDao.save(adminRole);

        Role UserRole = new Role();
        UserRole.setRoleName("User");
        UserRole.setRoleDescription("Default role for newly create record ");
        roleDao.save(UserRole);

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserPassword("admin@pass");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);
    }
}
