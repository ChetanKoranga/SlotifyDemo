FROM openjdk:11-jre-slim

WORKDIR usr/src

#COPY target/config-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","api-gateway-0.0.1-SNAPSHOT.jar"]
ADD ./target/interviewer-service-0.0.1-SNAPSHOT.jar /usr/src/interviewer-service-0.0.1-SNAPSHOT.jar