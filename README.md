# SocialMedia REST API Spring Boot

This project is a RESTful API built with Spring Boot for a social media platform. It allows authenticated users to post different types of content.
Installation

To run this project locally, follow these steps:

Clone the repository to your local machine:

bash

    git clone https://github.com/amtenu/SocialMedia_REST_API_Spring_boot.git

Navigate to the project directory:

bash

    cd SocialMedia_REST_API_Spring_boot

Open the src/main/resources/application.properties file and configure the H2 database settings:

properties

# H2 Database Configuration

spring.datasource.url=jdbc:h2:mem:social_media_db

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=password

spring.h2.console.enabled=true

# Hibernate properties

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect

spring.jpa.hibernate.ddl-auto=create-drop

Build the project using Maven:

bash

    mvn clean install

Run the project:

bash

    mvn spring-boot:run

Usage

Once the project is running, you can access the Swagger UI documentation at http://localhost:8080/swagger-ui.html to explore and interact with the API endpoints.
Technologies Used

    Spring Boot
    H2 Database
    Swagger/OpenAPI
    Spring Data JPA
    Content negotiation
    Dynamic Filtering of Endpoints
    Rest Api versioning 
    Spring Security
    HATEOAS
    ORM (One-to-many and Many-to-one)
