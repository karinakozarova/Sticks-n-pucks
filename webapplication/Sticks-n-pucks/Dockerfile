# docker build -t sticks-n-pucks .
# docker run -p 8080:8080 sticks-n-pucks

FROM openjdk:14-alpine

COPY ./build/libs/Sticks-n-pucks-0.0.1-SNAPSHOT.jar /usr/app/
RUN apk add --update \
    curl \
    && rm -rf /var/cache/apk/*

WORKDIR /usr/app

RUN curl -L https://services.gradle.org/distributions/gradle-6.5.1-bin.zip -o gradle-6.5.1-bin.zip
RUN unzip gradle-6.5.1-bin.zip
ENV GRADLE_HOME=/gradle/gradle-6.5.1
ENV PATH=$PATH:$GRADLE_HOME/bin
RUN gradle -v

# RUN sh -c 'touch Sticks-n-pucks-0.0.1-SNAPSHOT.jar'

RUN gradle bootrun

ENTRYPOINT ["java","-jar","Sticks-n-pucks-0.0.1-SNAPSHOT.jar"]