FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
#ENV PORT 8085
#EXPOSE 8085
ADD target/SpringK8SApi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
