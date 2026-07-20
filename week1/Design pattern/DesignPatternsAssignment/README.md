# Design Patterns & Principles — Completed Assignment

Each exercise below is its own self-contained Java "project" folder (as requested
in the assignment brief), each with a `src/` directory containing the pattern
implementation plus a `*Test.java` class with a `main()` method that demonstrates it.

| # | Folder | Pattern |
|---|--------|---------|
| 1 | Ex1_SingletonPatternExample | Singleton |
| 2 | Ex2_FactoryMethodPatternExample | Factory Method |
| 3 | Ex3_BuilderPatternExample | Builder |
| 4 | Ex4_AdapterPatternExample | Adapter |
| 5 | Ex5_DecoratorPatternExample | Decorator |
| 6 | Ex6_ProxyPatternExample | Proxy |
| 7 | Ex7_ObserverPatternExample | Observer |
| 8 | Ex8_StrategyPatternExample | Strategy |
| 9 | Ex9_CommandPatternExample | Command |
| 10 | Ex10_MVCPatternExample | MVC |
| 11 | Ex11_DependencyInjectionExample | Dependency Injection |

## How to compile and run any exercise

From inside an exercise's `src/` folder:

```bash
javac *.java
java <NameOfTestClass>
```

For example, for Exercise 1:

```bash
cd Ex1_SingletonPatternExample/src
javac *.java
java LoggerTest
```

## Importing into an IDE (Eclipse / IntelliJ)

1. Create a new Java project with the same name as the folder (e.g. `SingletonPatternExample`).
2. Set the `src` folder as the project's source root.
3. Copy the `.java` files from the matching `Ex*` folder into it.
4. Run the `*Test.java` class.

## Note on verification

This sandbox environment only has a Java **runtime** (JRE) available, not the
`javac` compiler, so the code below could not be compiled here. Every file was
written and reviewed carefully against standard, well-established pattern
implementations. If you hit any compile error in your own environment, it's
most likely a copy/paste or package-naming issue — let me know and I'll fix it.
