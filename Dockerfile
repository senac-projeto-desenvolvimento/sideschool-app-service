FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--spring.datasource.url=", "--spring.datasource.username=senacgrupo1", "--spring.datasource.password=senacgrupo1"]