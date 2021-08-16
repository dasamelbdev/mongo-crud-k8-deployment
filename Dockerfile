FROM openjdk:8-jdk-alpine
ADD target/mongo-crud-0.0.1-SNAPSHOT.jar /mongo-crud-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "mongo-crud-0.0.1-SNAPSHOT.jar"]