FROM openjdk:11.0.6-jdk
ARG BUILD_VERSION=0.0.1-SNAPSHOT
ADD target/rdbc-webflux-$BUILD_VERSION.jar rdbc-webflux.jar
EXPOSE 6080
ENTRYPOINT ["java","-jar","rdbc-webflux.jar"]