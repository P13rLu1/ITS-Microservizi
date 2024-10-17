FROM openjdk:17
ADD target/Esercizio07ExampleJarForDocker-0.0.1-SNAPSHOT.jar dockerFileExample.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "dockerFileExample.jar"]