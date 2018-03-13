## Created by Vamsi

#Downloading jre
FROM openjdk:8-jre

#Exposing port outside world communication
EXPOSE 8080

#Making a dir for Spring boot logs
RUN mkdir -m 777 -p data

#Creating a default app.log file
RUN touch data/myretail.log

#changing permissions for app.log file to read, write, execute
RUN chmod 777 data/myretail.log

#Copying maven packged jar to image local
COPY ./target/app.jar /app.jar

# Set the app label
LABEL app=my-retail

# Setting entry point for the execution
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
