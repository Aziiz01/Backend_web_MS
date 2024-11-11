FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the specific jar file from the target directory into the container
COPY target/Echere-service-0.0.1-SNAPSHOT.jar /app/EnchereService.jar

# Expose the port your application runs on
EXPOSE 8086

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "EnchereService.jar"]