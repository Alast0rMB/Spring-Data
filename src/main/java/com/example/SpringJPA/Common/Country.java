package com.example.SpringJPA.Common;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity //Creating entity for JPA
@Table(name = "COUNTRIES") //Table name in DB
@Cacheable //Is going to use L2 Cache
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE) //Enable type of Cache
public class Country {
    @Id //Each Entity needs and ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Simple Generation Type
    @Column(name = "COUNTRY_ID", nullable = false, length = 2)
    private String id;

    @NaturalId //A natural ID is used for things that are not specific id, but we use them in real world like full names
    @Column(name = "COUNTRY_NAME", nullable = false, length = 40)
    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY) //Fetch Lazy will allow us to load only the data that we want
    @OnDelete(action = OnDeleteAction.CASCADE) //Delete Country if Region is deleted
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE) //A bidirectional mapping so we can access locations
    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY,orphanRemoval = true)
    private Set<Location> locations = new LinkedHashSet<>();

    //Getter and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

}