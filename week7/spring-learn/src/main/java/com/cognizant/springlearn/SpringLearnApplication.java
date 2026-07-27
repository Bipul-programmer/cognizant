package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Inside main");

        try {
            // Hands On 2 & 3: Load SimpleDateFormat
            displayDate();

            // Hands On 4 & 5: Load Country & Demonstrate Prototype Scope
            displayCountry();

            // Hands On 6: Load List of Countries
            displayCountries();
        } catch (Exception e) {
            LOGGER.error("Execution exception: ", e);
        }
    }

    public static void displayDate() {
        LOGGER.info("START displayDate");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Error parsing date", e);
        }
        LOGGER.info("END displayDate");
    }

    public static void displayCountry() {
        LOGGER.info("START displayCountry");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        LOGGER.debug("Requesting first Country bean (demonstrating prototype scope)");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country: {}", country.toString());

        LOGGER.debug("Requesting second Country bean (demonstrating prototype scope)");
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Another Country: {}", anotherCountry.toString());

        LOGGER.info("END displayCountry");
    }

    public static void displayCountries() {
        LOGGER.info("START displayCountries");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        @SuppressWarnings("unchecked")
        List<Country> countryList = (List<Country>) context.getBean("countryList", java.util.ArrayList.class);

        LOGGER.debug("Country List: {}", countryList);
        LOGGER.info("END displayCountries");
    }
}
