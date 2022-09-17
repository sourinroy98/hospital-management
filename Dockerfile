FROM openjdk:17
ADD target/Hospital-management-1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9010
ENTRYPOINT ["java","-jar","/app.jar"]