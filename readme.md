# Gradle+geb+allure with AST transformations

## Description
Example project utilising GEB for web browser interactions, ALLURE for reporting and ast transformations for logging of methods execution both in console and Allure report.
Junit4 and Spock are used as test runner libraries.

To run all tests execute:
```
gradlew clean testParam allureReport
```

## Configuration
By default, all tests will be executed in chrome in 2 parallel threads and Allure report will be generated.

Available parameters:
```
TESTSUITE - path to the folder with tests to be executed
PARALEL_THREADS - number of parallel threads
TEST_BROWSER - browser in which tests will be executed
```

## Docker
```/Docker/docker-compose.yaml``` file is available - it will mount 2 containers: one with zalenium (tool akin to Selenium grid) and second with tests which will be executed using zalenium.

