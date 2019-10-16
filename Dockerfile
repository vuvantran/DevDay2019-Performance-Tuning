FROM openjdk:11.0.4-jdk

USER root
run mkdir /opt/devday2019

ADD ./devday2019project-0.0.1-SNAPSHOT.jar /opt/devday2019

run ls -l /opt/devday2019


# Set the default command to run on boot
# This will start Spring boot application
ENTRYPOINT ["java", "-jar", "/opt/devday2019/devday2019project-0.0.1-SNAPSHOT.jar"]