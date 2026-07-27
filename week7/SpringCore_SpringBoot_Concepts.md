# Spring Boot & Spring Core Concepts - Week 7

## 1. Need and Benefits of Spring Boot
Spring Boot makes it easy to create stand-alone, production-grade Spring-based applications that you can "just run".

### Key Benefits:
- **Auto-Configuration:** Automatically configures Spring and 3rd party libraries based on the dependencies present in the classpath.
- **Embedded Servers:** Embeds Tomcat, Jetty or Undertow directly, so there is no need to deploy WAR files.
- **Starter Dependencies:** Provides opinionated 'starter' dependencies (`spring-boot-starter-web`, `spring-boot-starter-data-jpa`) to simplify build configuration.
- **No XML Required:** Absolutely no code generation and no requirement for XML configuration (though XML is supported).
- **Reduced Development Time:** Drastically minimizes boilerplate code, setup time, and avoids tedious configuration steps.

---

## 2. Spring Core & IoC Container
The core of the Spring Framework is the **Inversion of Control (IoC) Container**. It is responsible for instantiating, configuring, and assembling objects known as **beans**.

### Bean Definition (XML Configuration):
In a traditional Spring setup, beans are defined in an XML file (e.g., `spring-beans.xml`).
```xml
<bean id="myBean" class="com.example.MyClass">
    <property name="propertyName" value="propertyValue" />
</bean>
```

### ApplicationContext:
`ApplicationContext` is the advanced interface for the IoC container. To load an XML configuration from the classpath:
```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
MyClass myBean = context.getBean("myBean", MyClass.class);
```

---

## 3. Bean Scopes: Singleton vs. Prototype
Spring supports multiple bean scopes. The two most common are:

| Scope | Description |
| :--- | :--- |
| **Singleton (Default)** | A single, shared instance of the bean is managed by the container. Every request for that bean ID returns the *same* instance. |
| **Prototype** | A *new* instance of the bean is created every time a request for that specific bean is made (`context.getBean()`). |

**Defining Scope in XML:**
```xml
<bean id="prototypeBean" class="com.example.MyClass" scope="prototype" />
```

---

## 4. Dependency Injection Types

### A. Constructor Injection
Dependencies are provided through the class constructor. It is highly recommended for mandatory dependencies to ensure the object is initialized in a valid state.
```xml
<bean id="dateFormat" class="java.text.SimpleDateFormat">
    <constructor-arg value="dd/MM/yyyy" />
</bean>
```

### B. Setter Injection
Dependencies are provided via setter methods after the object is instantiated. Typically used for optional dependencies.
```xml
<bean id="country" class="com.example.Country">
    <property name="name" value="India" />
    <property name="code" value="IN" />
</bean>
```

---

## 5. Incorporating Logging in Spring Boot (SLF4J + Logback)
Spring Boot uses **Logback** as the default logging framework, accessed via the **SLF4J** facade.

### `application.properties` configuration:
```properties
# Set log levels for specific packages
logging.level.org.springframework=info
logging.level.com.cognizant.springlearn=debug

# Define log output format
logging.pattern.console=%d{yyMMdd}|%d{HH:mm:ss.SSS}|%-20.20thread|%5p|%-25.25logger{25}|%25M|%m%n
```

### Usage in Java:
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyClass.class);

    public void doSomething() {
        LOGGER.info("START");
        LOGGER.debug("Debugging application state");
        LOGGER.info("END");
    }
}
```
*Note: Using `System.out.println()` is strongly discouraged in enterprise applications; robust logging frameworks provide asynchronous logging, log rotation, formatting, and configurable levels (TRACE, DEBUG, INFO, WARN, ERROR).*
