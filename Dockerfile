# Use official OpenJDK 17 image
FROM openjdk:17-jdk

# Set working directory
WORKDIR /app

# Copy all files to /app
COPY . .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the project (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Render will map it to $PORT)
EXPOSE 8080

# Run the Spring Boot jar (replace with your actual jar name in target/)
CMD ["java", "-jar", "target/UserManagmentSystem-0.0.1-SNAPSHOT.jar"]