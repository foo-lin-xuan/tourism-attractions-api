# Use a base image with Maven installed to build the project
FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the project
COPY src/ /app/src/
RUN mvn package

# Use another base image with OpenJDK to run the packaged application
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/singastays-0.0.1-SNAPSHOT.jar /app/singastays-0.0.1-SNAPSHOT.jar

# Start the Spring Boot application
CMD ["java", "-jar", "singastays-0.0.1-SNAPSHOT.jar"]

