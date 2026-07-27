package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");

        try {
            // Executing Hands-on test cases
            testGetAllCountries();
            getAllCountriesTest();
            testAddCountry();
            testUpdateCountry();
            testSearchCountry();
            testDeleteCountry();
        } catch (Exception e) {
            LOGGER.error("Execution error: ", e);
        }
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start - testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End - testGetAllCountries");
    }

    private static void getAllCountriesTest() {
        LOGGER.info("Start - getAllCountriesTest");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: ", e);
        }
        LOGGER.info("End - getAllCountriesTest");
    }

    private static void testAddCountry() {
        LOGGER.info("Start - testAddCountry");
        Country newCountry = new Country("ZZ", "Zemuria");
        countryService.addCountry(newCountry);
        try {
            Country country = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to find added country: ", e);
        }
        LOGGER.info("End - testAddCountry");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start - testUpdateCountry");
        countryService.updateCountry("ZZ", "Zemuria Republic");
        try {
            Country country = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to find updated country: ", e);
        }
        LOGGER.info("End - testUpdateCountry");
    }

    private static void testSearchCountry() {
        LOGGER.info("Start - testSearchCountry");
        List<Country> countries = countryService.getByPartialName("ou");
        LOGGER.debug("Countries matching 'ou': {}", countries);
        LOGGER.info("End - testSearchCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start - testDeleteCountry");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Successfully deleted country ZZ (Expected exception caught: {})", e.getMessage());
        }
        LOGGER.info("End - testDeleteCountry");
    }
}
