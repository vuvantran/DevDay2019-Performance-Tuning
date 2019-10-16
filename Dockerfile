#######
# Create package for deployment:
# mvn clean install
#
# How to build docker image: 
# docker build  -t devday_server:v1 .
#
# Start docker image:
# docker run -d --name devday-server  -it -p 8080:8080 devday_server:v1
#######
FROM openjdk:11.0.4-jdk

USER root
run mkdir /opt/devday2019

ADD ./target/devday2019project-0.0.1-SNAPSHOT.jar /opt/devday2019

run ls -l /opt/devday2019


# Set the default command to run on boot
# This will start Spring boot application by default on port 8080
ENTRYPOINT ["java", "-jar", "/opt/devday2019/devday2019project-0.0.1-SNAPSHOT.jar"]
