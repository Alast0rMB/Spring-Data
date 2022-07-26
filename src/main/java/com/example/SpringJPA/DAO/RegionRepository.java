package com.example.SpringJPA.DAO;

import com.example.SpringJPA.Common.Country;
import com.example.SpringJPA.Common.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}