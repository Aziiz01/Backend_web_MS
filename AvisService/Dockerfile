FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the specific jar file from the target directory into the container
COPY target/AvisService-1.0-SNAPSHOT.jar /app/AvisService.jar

# Expose the port your application runs on
EXPOSE 8084

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "AvisService.jar"]
