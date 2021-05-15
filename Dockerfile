FROM openjdk:8
COPY ./target/outreach_portal-0.0.1-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-cp", "outreach_portal-0.0.1-SNAPSHOT.jar", "OutreachPortalApplication"]