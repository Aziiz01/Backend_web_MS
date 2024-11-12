FROM openjdk:17
EXPOSE 8082
 ADD target/GestionPayement-0.0.1-SNAPSHOT.jar GestionPayement.jar
 ENTRYPOINT ["java", "-jar", "GestionPayement.jar"]