FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/awpag-api-0.0.1.jar awpag.jar

ENTRYPOINT [ "java", "-jar", "awpag.jar" ]