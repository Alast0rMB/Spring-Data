package com.example.SpringJPA.DTO;

import java.io.Serializable;
import java.util.Objects;

public class RegionDTO implements Serializable {
    private  Long id;
    private  String regionName;


    public Long getId() {
        return id;
    }
    public String getRegionName() {
        return regionName;
    }
    public void setId(Long id) {this.id = id;}
    public void setRegionName(String regionName) {this.regionName = regionName;}
}
