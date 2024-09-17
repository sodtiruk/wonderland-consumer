FROM openjdk:21-jdk

ARG LOCAL_APP_FILE=wonderlandconsumer-0.0.1-SNAPSHOT.jar

RUN mkdir /home/app

COPY target/${LOCAL_APP_FILE} /home/app/app.jar
#run localhost
#COPY /src/main/resources/application.yaml /home/app/config/application.yaml

WORKDIR /home/app

EXPOSE 8081

#run localhost
#ENTRYPOINT exec java -jar /home/app/app.jar --spring.config.location=/home/app/config/application.yaml
ENTRYPOINT exec java -jar /home/app/app.jar --spring.config.location=$SPRING_CONFIG




