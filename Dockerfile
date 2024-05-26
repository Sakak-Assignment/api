FROM openjdk:17
COPY build/libs/sakak.jar sakak.jar
ENTRYPOINT ["java", "-jar", "sakak.jar"]
