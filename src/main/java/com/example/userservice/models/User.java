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
    @OneToOne(cascade = CascadeType.PERSIST)
    private Name name;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
    private String phone;

}
