FROM maven:3.5.2-jdk-9 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8 
COPY --from=build /usr/src/app/target/SimpleApp-1.0.0-SNAPSHOT.jar /usr/app/SimpleApp-1.0.0-SNAPSHOT.jar  
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/SimpleApp-1.0.0-SNAPSHOT.jar"] 