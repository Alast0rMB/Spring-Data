package com.example.SpringJPA.DAO;

import com.example.SpringJPA.Common.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}