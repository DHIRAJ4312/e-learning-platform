FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml mvnw* ./
COPY .mvn .mvn
# copy source
COPY src ./src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /workspace/target/elearning-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
VOLUME /app/uploads
ENTRYPOINT ["java","-jar","/app/app.jar"]
