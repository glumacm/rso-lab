FROM openjdk:8-jre-slim

RUN mkdir /app

WORKDIR /app

#ADD ./api/target/users-api-1.0.0.jar /app
ADD ./users-api/target/users-api-1.0.0.jar /app
EXPOSE 8081

CMD java -jar users-api-1.0.0.jar