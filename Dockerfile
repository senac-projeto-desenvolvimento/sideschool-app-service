FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS="-Dspring.datasource.username=${DB_USER} -Dspring.datasource.password=${DB_PASS} -Dspring.datasource.url=${DB_URL}"
ENTRYPOINT ["java", "-Dspring.datasource.username=${DB_USER} -Dspring.datasource.password=${DB_PASS} -Dspring.datasource.url=${DB_URL}", "-jar", "/app.jar"]