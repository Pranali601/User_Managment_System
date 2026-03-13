# -----------------------------
# Stage 1: Build the project
# -----------------------------
FROM maven:3.9.2-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (for caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy all project files
COPY . .

# Build the project (skip tests for faster build)
RUN mvn clean package -DskipTests

# -----------------------------
# Stage 2: Create lightweight runtime image
# -----------------------------
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/User_Managment_System-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]