# Build a JAR File
FROM maven:3.8.2-jdk-8-slim AS build
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

# Create an Image
FROM openjdk:8-jdk-alpine
EXPOSE 5000
COPY --from=build /home/app/target/hello-world.jar hello-world.jar
ENTRYPOINT ["sh", "-c", "java -jar /hello-world.jar"]
