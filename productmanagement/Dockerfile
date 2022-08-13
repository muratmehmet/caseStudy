FROM openjdk:17-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
	JAVA_OPTS=""

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080


COPY target/*.jar /root/app.jar
