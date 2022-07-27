package com.example.SpringJPA.DAO;

import com.example.SpringJPA.Common.Region;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    List<Region> findAll();
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @EntityGraph(attributePaths = "countries")
    List<Region> findAll(Sort sort);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    Optional<Region> findById(Long id);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @EntityGraph(attributePaths = "countries")
    Region findCountryById(Long id);
}