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
    List<Region> findAll();
    @EntityGraph(attributePaths = "countries") //Mapping allows us to get countries while we are fetching region
    List<Region> findAll(Sort sort);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") }) //Used to cache query results. Different from caching data
    Optional<Region> findById(Long id);

    @EntityGraph(attributePaths = "countries")
    Region findCountryById(Long id);
}