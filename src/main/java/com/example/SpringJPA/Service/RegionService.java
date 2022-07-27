package com.example.SpringJPA.Service;

import com.example.SpringJPA.Common.Country;
import com.example.SpringJPA.Common.Region;
import com.example.SpringJPA.DAO.RegionRepository;
import com.example.SpringJPA.DTO.CountryDTO;
import com.example.SpringJPA.DTO.RegionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private CountryService countryService;
    @Autowired
    ModelMapper modelMapper;

    public Region save(Region region){return regionRepository.save(region);}

    public Region findId(Long id){return regionRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));}
    public List<Region> findAll(){return regionRepository.findAll();}
    public List<Region> findAllSort(String by){return regionRepository.findAll(Sort.by(by));}

    public Set<CountryDTO> getCountries(Long id){
        Region region =  regionRepository.findCountryById(id);
        Set<CountryDTO> countries = new HashSet<>();
        if(region == null)
            throw new RuntimeException("Resource not found!");
        for (Country country : region.getCountries())
            countries.add(countryService.convertDTO(country));
        return countries;
    }
    @Transactional //This annotation is used for performing the entire procedure in one transaction
    public Set<CountryDTO> getCountriesWithGet(Long id){
        Region region = findId(id);
        Set<CountryDTO> countries = new HashSet<>();
        for (Country country : region.getCountries())
            countries.add(countryService.convertDTO(country));
        return countries;
    }


    public RegionDTO convertDTO(Region region){return modelMapper.map(region,RegionDTO.class);}
}
