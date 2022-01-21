FROM maven:3.8.2-jdk-8-slim AS build
WORKDIR /home/app
COPY . /home/app
# 1. add pom.xml only here

COPY pom.xml .

RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]