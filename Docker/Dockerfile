FROM alpine/git AS clone-stage

RUN mkdir -p /opt/project && \
 git clone https://9c43856e151147fbb123bb8c3f9b319886b55ddf:x-oauth-basic@github.com/ostrovanka/geb-allure-gradle.git /opt/project

FROM gradle:jdk8-hotspot AS execution-stage
COPY --from=clone-stage /opt/project .
RUN chmod +x start.sh
ENTRYPOINT ["./start.sh", "remoteChrome"]


