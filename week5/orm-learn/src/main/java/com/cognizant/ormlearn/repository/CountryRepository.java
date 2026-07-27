package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Query Method to find countries containing a partial name
    List<Country> findByNameContaining(String name);

    // Query Method to find countries containing a partial name sorted alphabetically
    List<Country> findByNameContainingOrderByNameAsc(String name);
}
