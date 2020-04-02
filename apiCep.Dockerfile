FROM maven:3.6-jdk-11-slim AS packager

RUN mkdir -p /cep
WORKDIR /cep

ADD ./pom.xml .
ADD ./docker-entrypoint.sh /

RUN mvn install -B -e -f ./pom.xml

COPY ./ .


RUN mvn package -Dmaven.test.skip=true && \
    mv ./target/*.jar /run/api-cep.jar

FROM openjdk:11-slim

COPY --from=packager /run/api-cep.jar /var/cep/api-cep.jar
COPY --from=packager /docker-entrypoint.sh /docker-entrypoint.sh

RUN chmod +x /docker-entrypoint.sh

EXPOSE 8080

ENTRYPOINT [ "bash", "/docker-entrypoint.sh" ]
