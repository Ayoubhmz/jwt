package com.example.jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private Long idUser;
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Role> role;
}
