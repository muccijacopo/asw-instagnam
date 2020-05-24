FROM openjdk:8-jdk

ADD build/libs/ricette.jar ricette.jar

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "ricette.jar"]