FROM amazoncorretto:11-alpine-jdk 
MAINTAINER Nancy
COPY target/Nancy-0.0.1-SNAPSHOT.jar Nancy-app.jar 
ENTRYPOINT["java","-jar","/Nancy-app.jar"] 
