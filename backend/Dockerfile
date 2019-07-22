FROM openjdk:8-jdk-alpine
MAINTAINER kuzin.d
COPY target/backend-0.1.0-SNAPSHOT.jar /opt/spring-boot/lib/
VOLUME /target
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/spring-boot/lib/backend-0.1.0-SNAPSHOT.jar"]
EXPOSE 8080 5433