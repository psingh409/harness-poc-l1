# Use Managed Base Image Oracle JDK 11
FROM containerregistry-na.jpmchase.net/container-base/managedbaseimages/oracle-jdk:11-stable

# URL to get source code for building the image (string)
LABEL org.opencontainers.image.source="https://${REPO_HOSTNAME}/projects/${PROJECT}/repos/${REPO}/browse?at=${COMMIT_HASH}"

# Source control revision identifier for the packaged software. Hash of the commit for this
LABEL org.opencontainers.image.revision="${COMMIT_HASH}"

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