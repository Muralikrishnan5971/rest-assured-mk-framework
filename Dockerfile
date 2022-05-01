FROM muralikrishnan5971/testresource-java-mvn
COPY src home/restassuredframework/src
COPY pom.xml home/restassuredframework/pom.xml
COPY testng.xml home/restassuredframework/testng.xml
WORKDIR home/restassuredframework
ENTRYPOINT mvn clean test