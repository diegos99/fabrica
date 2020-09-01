FROM openjdk:8
EXPOSE 9001
ADD target/fabric.war fabric.war
ENTRYPOINT ["java","-jar","/fabric.war"]
