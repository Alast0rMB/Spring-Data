package com.example.SpringJPA.Controller;

import com.example.SpringJPA.Common.Region;
import com.example.SpringJPA.DTO.CountryDTO;
import com.example.SpringJPA.DTO.RegionDTO;
import com.example.SpringJPA.Service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/region")
public class RegionController {
    @Autowired
    private RegionService regionService;


    @GET
    @Produces("application/json")
    public List<RegionDTO> getAll(){
        List<Region> regions =  regionService.findAll();
        List<RegionDTO> regionDTOS = new ArrayList<>();
        for(Region region : regions)
            regionDTOS.add(regionService.convertDTO(region));
        return regionDTOS;
    }

    @GET
    @Path("/sort")
    @Produces("application/json")
    public List<RegionDTO> getAllSort(){
        List<Region> regions =  regionService.findAllSort();
        List<RegionDTO> regionDTOS = new ArrayList<>();
        for(Region region : regions)
            regionDTOS.add(regionService.convertDTO(region));
        return regionDTOS;
    }

    @GET
    @Path("/{id}/country")
    @Produces("application/json")
    public Set<CountryDTO> getCountries(@PathParam("id")Long id){
        return regionService.getCountriesDelay(id);
    }

    @GET
    @Path("/{id}/countryJoin")
    @Produces("application/json")
    public  Set<CountryDTO> getCountryGraph(@PathParam("id")Long id){
        return regionService.getCountries(id);
    }
}
