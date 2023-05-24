

FROM amazoncorretto:11-alpine-jdk //Imagen la cual partimos
MAINTAINER Nancy//Nombre del dueño del proyecto
COPY target/Nancy-0.0.1-SNAPSHOT.jar Nancy-app.jar //Va a copiar el empaquetado a Github
ENTRYPOINT["java","-jar","/Nancy-app.jar"] //Es la instrucción que se va a ejecutar primero
