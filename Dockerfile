FROM gradle:7-jdk17 AS b

RUN mkdir -p ~/.gradle && echo "org.gradle.daemon=false" >> ~/.gradle/gradle.properties

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle shadowJar --no-daemon

FROM eclipse-temurin:17-jre-alpine

COPY --from=b /home/gradle/src/build/libs/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]