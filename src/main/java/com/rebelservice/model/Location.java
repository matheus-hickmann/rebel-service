package com.rebelservice.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
@Data
public class Location {

    private Double latitude;
    private Double longitude;
    private String galaxyName;

}