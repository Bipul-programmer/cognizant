# ORM, Hibernate, and Spring Data JPA Walkthrough

## Objectives Covered
- Explain the need and benefit of ORM
- Demonstrate the need and benefit of Spring Data JPA
- Explain about core objects of hibernate framework
- Explain ORM implementation with Hibernate XML Configuration and Annotation Configuration
- Explain the difference between Java Persistence API, Hibernate and Spring Data JPA

---

## 1. Need and Benefit of ORM (Object-Relational Mapping)
**What is ORM?**
ORM is a programming technique used to convert data between incompatible type systems using object-oriented programming languages. In Java, it maps Java objects to database tables, allowing developers to interact with the database using object-oriented paradigms rather than writing raw SQL queries.

**Benefits of ORM:**
- **Productivity:** Reduces boilerplate code (JDBC connections, result set parsing).
- **Abstraction:** Hides the underlying database implementation details.
- **Maintainability:** Easier to update object mappings than raw SQL queries if the schema changes.
- **Transactionality:** Provides built-in mechanisms to handle transactions seamlessly.

---

## 2. Core Objects of the Hibernate Framework
Hibernate is a popular implementation of the Java Persistence API (JPA) specification.
- **Configuration:** Reads the configuration settings and mapping documents (XML or annotations) to establish a connection to the database.
- **SessionFactory:** A thread-safe, immutable object created from the Configuration. It acts as a factory for `Session` objects and holds the second-level cache. Typically, there is one `SessionFactory` per database.
- **Session:** A single-threaded, short-lived object representing a conversation between the application and the persistent store. It wraps a JDBC connection and acts as a factory for `Transaction`, `Query`, and `Criteria`. It holds the first-level cache.
- **Transaction:** A single-threaded, short-lived object used by the application to specify atomic units of work. It abstracts the underlying transaction implementation (JDBC or JTA).
- **Query:** An object used to retrieve data from the database using HQL (Hibernate Query Language) or native SQL.

---

## 3. Difference between JPA, Hibernate, and Spring Data JPA
- **JPA (Java Persistence API):** JPA is a specification (JSR 338) that defines how Java objects should be mapped to relational databases. It is purely a set of interfaces and rules; it does *not* provide any concrete implementation.
- **Hibernate:** Hibernate is an ORM tool that serves as a robust, fully-featured implementation of the JPA specification.
- **Spring Data JPA:** Spring Data JPA is not an implementation of JPA (it uses Hibernate under the hood by default). Instead, it is an abstraction layer that significantly reduces boilerplate code required to implement data access layers. It automatically generates repository implementations at runtime based on method names (e.g., `findByCode`).

---

## 4. Hibernate XML Configuration vs. Annotation Configuration
**XML Configuration:**
- Relies on mapping files (e.g., `Employee.hbm.xml`) to define how an entity maps to a table.
- The `hibernate.cfg.xml` file points to these mapping files.
- Separates mapping metadata from the Java source code, which can be useful if the database schema is managed separately, but requires maintaining multiple files.

**Annotation Configuration:**
- Uses Java annotations directly on the persistence class (e.g., `@Entity`, `@Table`, `@Id`, `@Column`).
- Keeps the mapping metadata close to the source code, making it easier to read and maintain.
- Spring Data JPA exclusively leverages this approach for simplicity and modern standard compliance.

---

## 5. Walkthrough of the `orm-learn` Implementation
### The Setup
1. **pom.xml:** Pulls in `spring-boot-starter-data-jpa` and `mysql-connector-j`. This automatically configures Hibernate as the JPA provider.
2. **application.properties:** Defines the JDBC connection details, Hibernate dialect, and ddl-auto setting (e.g., `validate`), along with logging configurations to trace SQL statements.

### The Code
- **`Country` Entity:** Annotated with `@Entity` and `@Table(name="country")`. The fields `code` and `name` are mapped to `co_code` and `co_name` using `@Column`. The `@Id` annotation marks `code` as the primary key.
- **`CountryRepository`:** An interface extending `JpaRepository<Country, String>`. Spring Data JPA automatically provides CRUD implementations (like `findById`, `save`, `deleteById`) at runtime.
- **`CountryService`:** Annotated with `@Service`. It injects the `CountryRepository` and wraps repository calls in methods annotated with `@Transactional`. The `@Transactional` annotation tells Spring to manage the database transaction automatically (opening session, beginning transaction, committing or rolling back on exception).
- **`OrmLearnApplication`:** The main class that bootstraps the Spring context. Using `ApplicationContext`, we retrieve the `CountryService` bean and execute various tests (Add, Update, Find, Delete).
