# Use Managed Base Image Oracle JDK 11
FROM openjdk:8-jre-alpine3.9



# Human-readable title of the image (string)
LABEL org.opencontainers.image.title=" i046364-eks-hello"

# Default the target version to 0.0.0-SNAPSHOT
ARG gavVersion=0.0.0-SNAPSHOT

# Override the version from environment, if present (helpful with CI tools)
ENV gavVersion ${gavVersion}

# Copy application to container's /app folder
COPY target/i046364-eks-hello-${gavVersion}.jar /app/

# Expand the jar contents to /app/ directory then delete the jar
RUN cd /app/ && jar -xvf /app/i046364-eks-hello-${gavVersion}.jar && rm /app/i046364-eks-hello-${gavVersion}.jar

# Change ownership to 'jpmcnobody' user aka account with least permissions
RUN chown -R jpmcnobody:jpmcnobody /app/
USER 99
# Command to run Spring Boot Application using JarLauncher
CMD java $JAVA_OPTS -cp /app/ org.springframework.boot.loader.JarLauncher
