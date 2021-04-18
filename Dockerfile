FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN echo ${JAR_FILE}
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
EXPOSE 80
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]