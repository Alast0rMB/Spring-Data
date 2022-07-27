package com.example.SpringJPA.Controller;

import com.example.SpringJPA.Common.Region;
import com.example.SpringJPA.DTO.CountryDTO;
import com.example.SpringJPA.DTO.RegionDTO;
import com.example.SpringJPA.Service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/region")
public class RegionController {
    @Autowired
    private RegionService regionService;


    @GET
    @Produces("application/json")
    public List<RegionDTO> getAll(@DefaultValue("")@QueryParam("sort")String sort){
        List<Region> regions;
        if(sort.equals("")) {
            regions = regionService.findAll();
        }
        else {
            regions = regionService.findAllSort(sort);
        }
        List<RegionDTO> regionDTOS = new ArrayList<>();
        for(Region region : regions)
            regionDTOS.add(regionService.convertDTO(region));
        return regionDTOS;
    }


    @GET
    @Path("/{id}/country")
    @Produces("application/json")
    public Set<CountryDTO> getCountries(@PathParam("id")Long id){
        return regionService.getCountriesWithGet(id);
    }

    @GET
    @Path("/{id}/countryJoin")
    @Produces("application/json")
    public  Set<CountryDTO> getCountryGraph(@PathParam("id")Long id){
        return regionService.getCountries(id);
    }
}
