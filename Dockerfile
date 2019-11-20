FROM openjdk:11.0.4-jdk

WORKDIR /backend-service
COPY /target/devday2019project-0.0.1-SNAPSHOT.jar /backend-service

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/backend-service/devday2019project-0.0.1-SNAPSHOT.jar"]
