FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the specific jar file from the target directory into the container
COPY target/OffreService-0.0.1-SNAPSHOT.jar /app/OffreService.jar

# Expose the port your application runs on
EXPOSE 8083

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "OffreService.jar"]
