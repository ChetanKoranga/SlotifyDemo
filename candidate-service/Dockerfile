FROM openjdk:11-jre-slim
MAINTAINER vinayak.horambali
WORKDIR usr/src
#COPY target/config-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","candidate-service-0.0.1-SNAPSHOT.jar"]
ADD ./target/candidate-service-0.0.1-SNAPSHOT.jar /usr/src/candidate-service-0.0.1-SNAPSHOT.jar
