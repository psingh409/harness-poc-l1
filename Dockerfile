# Use Managed Base Image Oracle JDK 11
FROM openjdk:8-jre-alpine3.9



# Human-readable title of the image (string)
LABEL org.opencontainers.image.title=" i046364-eks-hello"

LABEL cicd.pipeline.execution.url = <+pipeline.execution.url>

# Default the target version to 0.0.0-SNAPSHOT
ARG gavVersion=0.0.0-SNAPSHOT

# Override the version from environment, if present (helpful with CI tools)
ENV gavVersion ${gavVersion}


# Copy the already build jar to the image
COPY target/i046364-eks-hello-${gavVersion}.jar /bin/

# Expose default port for external communication
EXPOSE 8443

# Command to run the executable
ENTRYPOINT [ "java" ,"-jar",  "/bin/i046364-eks-hello-0.0.0-SNAPSHOT.jar" ]
#CMD java $JAVA_OPTS -cp /bin/ org.springframework.boot.loader.JarLauncher


