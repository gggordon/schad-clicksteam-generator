# Author GGordon
# This is apart of a larger project SCHAD
# Image to run SCHAD Clickstream Generator
# See https://github.com/gggordon/schad-clicksteam-generator

FROM openjdk:latest

# Specifies which port the streaming context should be available to clients
ARG port=5005
ENV PORT=$port

# Specifies how frequently a new message should be prepared
ARG interval=1000
ENV INTERVAL=$interval

WORKDIR /app

COPY schad-clickstream-generator-1.0.0.jar ./

CMD ["sh","-c","java -jar schad-clickstream-generator-1.0.0.jar --port=${PORT} --interval=${INTERVAL}"]
