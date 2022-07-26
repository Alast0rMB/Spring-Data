package com.example.SpringJPA.DAO;

import com.example.SpringJPA.Common.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}