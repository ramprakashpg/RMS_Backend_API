FROM openjdk:19-jdk
EXPOSE 8000
COPY ./build/libs/RMS_Backend_API-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","RMS_Backend_API-0.0.1-SNAPSHOT.jar"]