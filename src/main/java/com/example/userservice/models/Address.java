package com.example.userservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address{

    private String city;
    private String street;
    private int number;
    private String zipcode;
//    @OneToOne(cascade = CascadeType.PERSIST)
    @Embedded
    private GeoLocation geolocation;
}
