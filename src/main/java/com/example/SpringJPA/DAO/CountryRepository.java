package com.example.SpringJPA.DAO;

import com.example.SpringJPA.Common.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}