FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/tag-service0.0.1-SNAPSHOT.jar /usr/src/tag-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","tag-service-0.0.1-SNAPSHOT.jar"]