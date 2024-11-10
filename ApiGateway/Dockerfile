FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the specific jar file from the target directory into the container
COPY target/ApiGateway-1.0-SNAPSHOT.jar /app/ApiGateway.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "ApiGateway.jar"]
