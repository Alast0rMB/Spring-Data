package com.example.SpringJPA.DTO;

import java.io.Serializable;
import java.util.Objects;

public class CountryDTO implements Serializable {
    private  String id;
    private  String countryName;

    public CountryDTO(){}

    public void setId(String id) {
        this.id = id;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }
}
