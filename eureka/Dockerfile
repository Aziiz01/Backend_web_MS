FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the specific jar file from the target directory into the container
COPY target/eureka-0.0.1-SNAPSHOT.jar /app/Eureka.jar

# Expose the port your application runs on
EXPOSE 8761

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "Eureka.jar"]
