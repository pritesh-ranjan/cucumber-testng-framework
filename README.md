# Cucumber TestNG Framework

## Overview

This project is a multi-module Maven-based test automation framework that integrates Cucumber with TestNG. It is designed to support parallel test execution, manage browser configurations, and maintain a clean codebase with reusable components.

## Project Structure

The project is organized into four modules:

1. **`automation-framework`**:
    - Contains all reusable code, such as utility methods, common page objects, and hooks.
    - Shared across the other modules.

2. **`core-product-tests`**:
    - Holds test cases specific to the core product.
    - Utilizes code from the `automation-framework` module.

3. **`derived-product1-tests`**:
    - Contains test cases for the derived product 1.
    - Uses shared code from the `automation-framework` module.

4. **`derived-product2-tests`**:
    - Contains test cases for the derived product 2.
    - Leverages reusable code from the `automation-framework` module.

## Features

- **Cucumber Hooks for Driver Management**:
    - Provides setup and teardown functionality for managing WebDriver instances.

- **Parallel Execution**:
    - Configured using `testng.xml` to enable parallel execution of tests, improving test execution speed.

- **Tag-Based Execution**:
    - Cucumber tags can be specified via `testng.xml` to filter and execute specific test scenarios.

- **Page Object Model (POM)**:
    - Page locators are organized using the Page Object Model design pattern for better maintainability and readability.

- **Independent Components**:
    - **Feature Files**: Define test scenarios in a Gherkin language.
    - **Step Definitions**: Map steps in feature files to Java methods.
    - **Business Logic**: Implemented in service layers and called by step definitions.
    - **Page Objects**: Represent pages and elements on those pages.
    - **Test Data**: Managed separately for different test scenarios.
    - **Reusable Utility Methods**: Contain common functionalities used across tests.

- **Browser Selection**:
    - Browser configurations are handled via a properties file, allowing dynamic selection of browsers for test execution.



### Setup
1. Clone the repository.
2. Navigate to the project root and execute `mvn clean install` to build the project and download the necessary dependencies.
3. Configure the browser selection in the `config.properties` file located in the `automation-framework` module.

### Running Tests
- Use the `testng.xml` file to execute tests. The file allows configuration for parallel execution, test tagging, and more.
- To run tests with specific Cucumber tags, modify the `testng.xml` file accordingly.

### Directory Structure
- **src/main/java**: Contains Java code for the framework.
- **src/test/resources**: Contains Feature Files and test resources like data files.

## Contribution
Please feel free to contribute to this project by opening pull requests or reporting issues.

