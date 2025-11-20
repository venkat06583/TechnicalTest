# Technical Test Project – Technologies Used (Java 17, Selenium, Cucumber, Maven)

This project automates test scenarios for the John Lewis e-commerce website (https://www.johnlewis.com).

## Structure
- `src/test/resources/features` - Gherkin feature files
- `src/test/java/johnlewis/stepdefinations` - Cucumber step definitions
- `src/main/java/johnlewis/pages` - Page Object classes
- `pom.xml` - Maven build file

## How to run
1. Ensure Java 17 and Maven are installed.
2.From project root run:
```
mvn test
```
This will execute the tests and produce a report at `target/cucumber-report.html`.

Note: The generated Cucumber report file can be found in the project root as `cucumber-report.html`.
