FROM openjdk:16-alpine3.13
MAINTAINER com.example.ui
COPY target/UI_Bank-0.0.1-SNAPSHOT.jar ui-bank-0.0.1.jar
ENTRYPOINT ["java","-jar","/ui-bank-0.0.1.jar"]


