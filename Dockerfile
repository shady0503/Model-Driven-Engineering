# Build stage
FROM maven:3.9-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
COPY model ./model
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/mde-gen.jar app.jar
COPY --from=build /app/model ./model
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
