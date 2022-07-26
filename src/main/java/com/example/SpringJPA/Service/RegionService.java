package com.example.SpringJPA.Service;

import com.example.SpringJPA.Common.Region;
import com.example.SpringJPA.DAO.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public Region save(Region region){return regionRepository.save(region);}

    public Region findId(Long id){return regionRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));}

}
