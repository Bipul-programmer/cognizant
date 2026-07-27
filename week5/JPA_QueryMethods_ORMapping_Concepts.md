# Spring Data JPA Query Methods & O/R Mapping Concepts - Week 5

## 1. Query Methods in Spring Data JPA
Spring Data JPA provides a **Query Creation** mechanism that automatically parses method names and generates SQL queries at runtime without writing `@Query` annotations or native SQL strings.

### Derived Query Method Keywords:

| Keyword | Repository Method Signature Example | Generated SQL Equivalent |
| :--- | :--- | :--- |
| **Containing** | `findByNameContaining(String name)` | `WHERE name LIKE %?1%` |
| **StartingWith** | `findByNameStartingWith(String prefix)` | `WHERE name LIKE ?1%` |
| **Between** | `findByDateBetween(Date start, Date end)` | `WHERE date BETWEEN ?1 AND ?2` |
| **GreaterThan** | `findByCloseGreaterThan(BigDecimal price)` | `WHERE close > ?1` |
| **Top / First** | `findTop3ByOrderByVolumeDesc()` | `ORDER BY volume DESC LIMIT 3` |
| **OrderBy** | `findByNameContainingOrderByNameAsc(String name)` | `WHERE name LIKE %?1% ORDER BY name ASC` |

---

## 2. Object-Relational Mapping (O/R Mapping) Relationships

### A. `@ManyToOne` (Many Employees -> One Department)
- Maps a child entity back to a single parent entity.
- Uses `@JoinColumn(name = "em_dp_id")` to specify the foreign key column in the child table.
- **Default Fetch Type:** `FetchType.EAGER` (Parent object details are loaded along with child entity).

```java
@ManyToOne
@JoinColumn(name = "em_dp_id")
private Department department;
```

---

### B. `@OneToMany` (One Department -> Many Employees)
- Maps a parent entity to a collection of child entities (`Set<Employee>` or `List<Employee>`).
- Uses `mappedBy = "department"` to indicate that the relationship is managed by the `department` field in `Employee`.
- **Default Fetch Type:** `FetchType.LAZY` (Collection loaded on-demand). Accessing lazy collections outside active transaction context throws `LazyInitializationException`.
- **Eager Fetching:** Configured using `fetch = FetchType.EAGER`.

```java
@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
private Set<Employee> employeeList;
```

---

### C. `@ManyToMany` (Many Employees <-> Many Skills)
- Connects two entities via a junction/join table (`employee_skill`).
- Defined using `@JoinTable` on the owning side and `mappedBy` on the inverse side.

```java
// Owning Side (Employee.java)
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "employee_skill",
    joinColumns = @JoinColumn(name = "es_em_id"),
    inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
private Set<Skill> skillList;

// Inverse Side (Skill.java)
@ManyToMany(mappedBy = "skillList")
private Set<Employee> employeeList;
```

---

## 3. Eager vs. Lazy Fetching (`FetchType`)

| Feature | `FetchType.EAGER` | `FetchType.LAZY` |
| :--- | :--- | :--- |
| **Behavior** | Associated data is loaded immediately along with the main entity using SQL `LEFT JOIN` or separate query. | Associated data is loaded only when getter method is explicitly called. |
| **Default For** | `@ManyToOne`, `@OneToOne` | `@OneToMany`, `@ManyToMany` |
| **Risk** | Can cause memory overhead if fetching huge datasets. | Throws `LazyInitializationException` if accessed outside active transaction. |
