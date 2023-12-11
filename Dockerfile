FROM openjdk:17-jdk
EXPOSE 8000
ARG JAR_FILE=./build/libs/RMS_Backend_API-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","RMS_Backend_API-0.0.1-SNAPSHOT.jar"]