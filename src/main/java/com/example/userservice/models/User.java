package com.example.userservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{

    private String email;
    private String username;
    private String password;
    @Embedded
    private Name name;
//    @OneToOne(cascade = CascadeType.PERSIST)
    @Embedded
    private Address address;
    private String phone;
//    private String state; // removed to test jpa migration version

}
