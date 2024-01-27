package com.example.userservice.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class GeoLocation{
    private String latitude;
    private String longitude;
}
