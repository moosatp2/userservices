package com.example.userservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends BaseModel{

    private String city;
    private String street;
    private int number;
    private String zipcode;
    @OneToOne(cascade = CascadeType.PERSIST)
    private GeoLocation geolocation;
}
