package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry()");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
        List<Country> countryList = (List<Country>) context.getBean("countryList", java.util.ArrayList.class);

        LOGGER.debug("Searching for country code: {}", code);
        Country foundCountry = countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);

        if (foundCountry == null) {
            LOGGER.error("Country not found for code: {}", code);
            throw new CountryNotFoundException("Country not found");
        }

        LOGGER.info("END - getCountry()");
        return foundCountry;
    }
}
