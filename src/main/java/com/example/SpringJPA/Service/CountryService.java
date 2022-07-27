package com.example.SpringJPA.Service;

import com.example.SpringJPA.Common.Country;
import com.example.SpringJPA.DTO.CountryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service //Is used to show Service model
public class CountryService {
    @Autowired
    ModelMapper modelMapper; //Autowired's are initialized at the beginning of application

    //Converting Entity to DTO
    public CountryDTO convertDTO(Country country){return modelMapper.map(country,CountryDTO.class);}

}
