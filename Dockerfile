FROM maven:3.8.4-openjdk-17

WORKDIR /test-gateway
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run