FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV USER=${DB_USER}
ENV PASS=${DB_PASSWORD}
ENV URL=${DB_URL}
ENTRYPOINT ["java","-jar","/app.jar", "-Xmx128m"]