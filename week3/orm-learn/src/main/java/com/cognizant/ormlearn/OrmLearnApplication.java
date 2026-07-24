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
            // Uncomment the methods below to test after database is populated
            // testGetAllCountries();
            // getAllCountriesTest();
            // testAddCountry();
            // testUpdateCountry();
            // testDeleteCountry();
        } catch (Exception e) {
            LOGGER.error("Error occurred: ", e);
        }
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    private static void getAllCountriesTest() throws CountryNotFoundException {
        LOGGER.info("Start getAllCountriesTest");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country:{}", country);
        LOGGER.info("End getAllCountriesTest");
    }

    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country("ZZ", "Zemuria");
        countryService.addCountry(newCountry);
        Country country = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Added Country:{}", country);
        LOGGER.info("End testAddCountry");
    }

    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start testUpdateCountry");
        countryService.updateCountry("ZZ", "Zemuria Updated");
        Country country = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Updated Country:{}", country);
        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Country successfully deleted, exception thrown as expected.");
        }
        LOGGER.info("End testDeleteCountry");
    }
}
