# The docker image will use open jdk 11
FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine

# Copies the Fat JAR into the docker image
COPY ./target/OpenTides.jar /opt/tides/OpenTides.jar

# Copy the start script into the image
COPY ./scripts/start.sh /opt/tides/start.sh

# Makes the shell script executable
RUN ["chmod", "+x", "/opt/tides/start.sh"]

# When the docker image starts it runs the app
CMD ["/bin/sh", "-cx", "/opt/tides/start.sh"]