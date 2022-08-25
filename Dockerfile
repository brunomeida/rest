# Part 1: Build the app using Maven
FROM maven:3-openjdk-18
COPY . .
##ARG PORT_BUILD=6000
##ENV PORT=$PORT_BUILD
##EXPOSE $PORT_BUILD
EXPOSE 8080
RUN mvn clean install -DskipTests
ENTRYPOINT mvn spring-boot:run -DskipTests