FROM openjdk:11-jdk
FROM maven:3-jdk-11
RUN mvn clean install
VOLUME /tmp
EXPOSE 8080
ADD target/api-persona-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "application.jar"]