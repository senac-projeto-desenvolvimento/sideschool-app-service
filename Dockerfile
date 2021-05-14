FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Xmx128m", "--spring.datasource.url=jdbc:mysql://104.41.47.74:3306/sideschooldb", "--spring.datasource.username=senacgrupo1", "--spring.datasource.password=senacgrupo1"]