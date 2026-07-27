package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Search containing text
    List<Country> findByNameContaining(String name);

    // Search containing text sorted in ascending order
    List<Country> findByNameContainingOrderByNameAsc(String name);

    // Search starting with alphabet character
    List<Country> findByNameStartingWith(String prefix);
}
