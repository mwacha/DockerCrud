# our base build image
FROM maven:3.5-jdk-8 as MAVEN_TOOL_CHAIN

COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

# our final base image
FROM openjdk:8u171-jre-alpine

# set deployment directory
WORKDIR /dockercrud

# copy over the built artifact from the maven image
COPY target/*.jar ./dockercrud/target/dockercrud.jar

# set the startup command to run your binary
CMD ["java", "-jar", "./dockercrud/target/dockercrud.jar"]