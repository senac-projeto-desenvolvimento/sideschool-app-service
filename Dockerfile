FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--spring.datasource.username=${USER}", "--spring.datasource.password=${DB_PASS}", "--spring.datasource.url=${DB_URL}"]