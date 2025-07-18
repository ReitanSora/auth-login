FROM gradle:8.7-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle assemble --no-daemon

FROM openjdk:17-slim
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/auth-0.0.1-SNAPSHOT.jar /auth.jar
ENTRYPOINT ["java","-jar","/auth.jar"]