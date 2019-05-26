# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

# Profiles in Spring Boot

Spring Boot supports all the profile configuration outlined so far, with a few additional features.

The initialization parameter [spring.profiles.active] can be set up as a property in Spring Boot to define currently active profiles. This is a standard property that Spring Boot will pick up automatically:

[spring.profiles.active=dev]

To set profiles programmatically, we can also use the SpringApplication class:

1
[SpringApplication.setAdditionalProfiles("dev");]

To set profiles using Maven in Spring Boot, we can specify profile names under spring-boot-maven-plugin in pom.xml:

[<plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
            <profiles>
                <profile>dev</profile>
            </profiles>
        </configuration>
    </plugin>
    ...
</plugins>]

And execute the Spring Boot specific Maven goal:


[mvn spring-boot:run]

But the most important profiles-related feature that Spring Boot brings is profile-specific properties files. These have to be named in the format [applications-{profile}.properties].

Spring Boot will automatically load the properties in an application.properties file for all profiles, and the ones in profile-specific .properties files only for the specified profile.

For example, we can configure different data sources for dev and production profiles by using two files named [application-dev.properties] and [application-production.properties]:

In the application-production.properties file, we can set up a MySql data source:

[spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/db
spring.datasource.username=root
spring.datasource.password=root]

Then, we can configure the same properties for the dev profile in the application-dev.properties file, to use an in-memory H2 database:

[spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1
spring.datasource.username=sa
spring.datasource.password=sa]

In this way, we can easily provide different configurations for different environments.
