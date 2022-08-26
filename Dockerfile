FROM openjdk:11-jdk
VOLUME /tmp
EXPOSE 8080
ADD target/api-personas-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "application.jar"]