FROM java:8

CMD ["mkdir", "/usr/bin/wowcraft"]
WORKDIR /usr/bin/wowcraft/

COPY target/wowcraft-rest.jar /usr/bin/wowcraft
ENTRYPOINT ["java", "-jar" , "wowcraft-rest.jar"]