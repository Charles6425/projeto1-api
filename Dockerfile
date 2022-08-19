FROM openjdk
WORKDIR /app
COPY target/projeto1-0.0.1-SNAPSHOT.jar /app/projeto1-api.jar
ENTRYPOINT ["java","-jar","projeto1-api.jar"]