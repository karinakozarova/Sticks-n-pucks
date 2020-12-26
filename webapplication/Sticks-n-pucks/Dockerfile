# Dockerfile for the Sticks-n-pucks Web application project 
# To build use: docker build -t sticks-n-pucks .
# To run use: docker run --rm -p 8888:8081 docker.io/library/sticks-n-pucks
# Access at http://localhost:8888/ on your local PC

# using an Alpine, OpenJDK 11, JRE docker image
FROM fabric8/java-alpine-openjdk11-jre 
COPY . /usr/app/
WORKDIR /usr/app

# installing dependencies
RUN apk add curl
RUN apk add tar
RUN apk add bash
RUN apk add procps
RUN apk add nodejs npm

# FOR DEBUGGING ONLY:
# To see the node and npm versions
# RUN node -v
# RUN npm -v

# GRADLE SETUP
# Define Gradle version to download
ARG GRADLE_VERSION=6.5.1

# URL for downloading gradle
ARG GRADLE_BASE_URL=https://services.gradle.org/distributions

# Create the directories
RUN mkdir -p /usr/share/gradle /usr/share/gradle/ref

# Download gradle
RUN curl -fsSL -o /tmp/gradle.zip ${GRADLE_BASE_URL}/gradle-${GRADLE_VERSION}-bin.zip

# Install gradle
RUN unzip -d /usr/share/gradle /tmp/gradle.zip

# Remove downloaded file
RUN rm -f /tmp/gradle.zip

# Set links
RUN ln -s /usr/share/gradle/gradle-${GRADLE_VERSION} /usr/bin/gradle

# Define environmental variables required by gradle
ENV GRADLE_VERSION 4.0.1
ENV GRADLE_HOME /usr/bin/gradle
ENV GRADLE_USER_HOME /cache
ENV PATH $PATH:$GRADLE_HOME/bin

# Creates a mount point 
VOLUME $GRADLE_USER_HOME

# List the avilable gradle tasks
RUN gradle tasks

# Expose the gradle port that is used for the bootrun
EXPOSE 8081

CMD ["gradle", "bootrun"]