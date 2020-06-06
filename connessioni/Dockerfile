FROM openjdk:8-jdk-alpine
ADD build/libs/connessioni.jar connessioni.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "connessioni.jar"]