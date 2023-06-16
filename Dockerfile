# Use a Java 11 base image
FROM openjdk:11-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the application's JAR file to the container
COPY build/libs/drones-service-1.0.0.jar /app

# Expose port 8080
EXPOSE 8080

# Run the JAR file when the container starts
CMD ["java", "-jar", "drone-service-1.0.0.jar"]
