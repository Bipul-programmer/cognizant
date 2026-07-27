package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryRepository countryRepository;
    private static StockRepository stockRepository;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryRepository = context.getBean(CountryRepository.class);
        stockRepository = context.getBean(StockRepository.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        LOGGER.info("Inside main - OrmLearnApplication Relationships & Query Methods");

        try {
            // Hands On 1: Country Query Methods
            testSearchCountryContaining();
            testSearchCountryContainingOrderByNameAsc();
            testSearchCountryStartingWith();

            // Hands On 2: Stock Query Methods
            testStockFBSeptember2019();
            testStockGoogleGreaterThan1250();
            testStockTop3Volume();
            testStockTop3LowestNetflix();

            // Hands On 4, 5, 6: Relationships
            testGetEmployee();
            testAddEmployee();
            testUpdateEmployee();
            testGetDepartment();
            testAddSkillToEmployee();
        } catch (Exception e) {
            LOGGER.error("Execution exception: ", e);
        }
    }

    // --- Hands On 1: Country Query Methods ---
    private static void testSearchCountryContaining() {
        LOGGER.info("Start - testSearchCountryContaining ('ou')");
        List<Country> countries = countryRepository.findByNameContaining("ou");
        for (Country c : countries) {
            LOGGER.debug("Country: {}", c);
        }
        LOGGER.info("End - testSearchCountryContaining");
    }

    private static void testSearchCountryContainingOrderByNameAsc() {
        LOGGER.info("Start - testSearchCountryContainingOrderByNameAsc ('ou')");
        List<Country> countries = countryRepository.findByNameContainingOrderByNameAsc("ou");
        for (Country c : countries) {
            LOGGER.debug("Sorted Country: {}", c);
        }
        LOGGER.info("End - testSearchCountryContainingOrderByNameAsc");
    }

    private static void testSearchCountryStartingWith() {
        LOGGER.info("Start - testSearchCountryStartingWith ('Z')");
        List<Country> countries = countryRepository.findByNameStartingWith("Z");
        for (Country c : countries) {
            LOGGER.debug("Country Starting With Z: {}", c);
        }
        LOGGER.info("End - testSearchCountryStartingWith");
    }

    // --- Hands On 2: Stock Query Methods ---
    private static void testStockFBSeptember2019() throws Exception {
        LOGGER.info("Start - testStockFBSeptember2019");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2019-09-01");
        Date endDate = sdf.parse("2019-09-30");

        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", startDate, endDate);
        for (Stock s : stocks) {
            LOGGER.debug("FB Sep Stock: {}", s);
        }
        LOGGER.info("End - testStockFBSeptember2019");
    }

    private static void testStockGoogleGreaterThan1250() {
        LOGGER.info("Start - testStockGoogleGreaterThan1250");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250.00"));
        for (Stock s : stocks) {
            LOGGER.debug("GOOGL > 1250 Stock: {}", s);
        }
        LOGGER.info("End - testStockGoogleGreaterThan1250");
    }

    private static void testStockTop3Volume() {
        LOGGER.info("Start - testStockTop3Volume");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        for (Stock s : stocks) {
            LOGGER.debug("Top 3 Volume Stock: {}", s);
        }
        LOGGER.info("End - testStockTop3Volume");
    }

    private static void testStockTop3LowestNetflix() {
        LOGGER.info("Start - testStockTop3LowestNetflix");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        for (Stock s : stocks) {
            LOGGER.debug("Lowest 3 NFLX Stock: {}", s);
        }
        LOGGER.info("End - testStockTop3LowestNetflix");
    }

    // --- Hands On 4, 5, 6: Relationships ---
    private static void testGetEmployee() {
        LOGGER.info("Start - testGetEmployee");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkillList());
        LOGGER.info("End - testGetEmployee");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start - testAddEmployee");
        Employee employee = new Employee();
        employee.setName("Mark Vance");
        employee.setSalary(90000.00);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());

        Department department = departmentService.get(1);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Added Employee: {}", employee);
        LOGGER.info("End - testAddEmployee");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start - testUpdateEmployee");
        Employee employee = employeeService.get(1);
        Department department = departmentService.get(2);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Updated Employee Department: {}", employee);
        LOGGER.info("End - testUpdateEmployee");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start - testGetDepartment");
        Department department = departmentService.get(1);
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Department Employees: {}", department.getEmployeeList());
        LOGGER.info("End - testGetDepartment");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start - testAddSkillToEmployee");
        Employee employee = employeeService.get(1);
        Skill skill = skillService.get(3);

        Set<Skill> skills = employee.getSkillList();
        skills.add(skill);
        employee.setSkillList(skills);

        employeeService.save(employee);
        LOGGER.debug("Updated Employee Skills: {}", employee.getSkillList());
        LOGGER.info("End - testAddSkillToEmployee");
    }
}
