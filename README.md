# Item Management Service

This project is a sample Spring Boot application with a focus on item management. It demonstrates various testing approaches such as unit testing, integration testing (IT), and mocking using different frameworks and libraries.

## Technologies Used
- **Java 21**: The latest stable version of Java.
- **Spring Boot**: Framework used for building production-ready applications.
- **H2 Database**: In-memory database for testing purposes.
- **Mockito**: A framework used for mocking dependencies in unit tests.
- **JUnit 5**: Framework for writing unit tests.
- **JsonPath**: Library for querying and extracting data from JSON documents.
- **AssertJ**: For fluent assertions in tests.
- **Hamcrest**: A library of matchers for more readable and expressive assertions.

## Project Structure
The project contains the following main components:
1. **Business Logic Layer**:
   - `ItemBusinessService`: A service responsible for handling item data.
   - `SomeBusinessImpl`: A service for some business logic involving data calculations.
   
2. **Controller Layer**:
   - `ItemController`: A REST controller that handles HTTP requests related to items.
   
3. **Model Layer**:
   - `Item`: A simple entity representing an item in the system.

4. **Repository Layer**:
   - `ItemRepository`: A Spring Data JPA repository for managing items.

5. **Tests**:
   - **Unit Tests**: Tests focusing on individual components or methods.
   - **Integration Tests (IT)**: Tests verifying the interaction between components.
   - **Mocking Tests**: Using Mockito to mock dependencies and test logic in isolation.
   - **JsonPath Tests**: For testing responses from REST APIs by extracting data using JSONPath queries.
   - **AssertJ and Hamcrest Tests**: For more readable assertions in unit tests.

## Setup and Requirements

### Prerequisites
- **Java 21**
- **Maven** for managing dependencies
- **Spring Boot** dependencies for building the app

### Running the Project

To run the project, clone the repository and build the project using Maven:

```bash
git clone <repository_url>
cd <project_directory>
mvn clean install
mvn spring-boot:run

### License
This project is licensed under the MIT License.


This README outlines the project, its technologies, testing approaches, and includes some examples of the different kinds of tests used throughout. Feel free to clone it and modify it according to your needs.
