FROM openjdk:17
ADD /target/demo1-1.0.jar backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]