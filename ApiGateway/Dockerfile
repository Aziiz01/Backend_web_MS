# Étape 1 : Choisir l'image de base
FROM openjdk:17-jdk-slim

# Étape 2 : Spécifier le répertoire de travail
WORKDIR /app

# Étape 3 : Ajouter le fichier JAR de l'application
# Remplacez "nom-de-votre-application.jar" par le nom réel de votre fichier JAR
ADD target/ApiGateway-1.0-SNAPSHOT.jar app.jar

# Étape 4 : Exposer le port de l'application
EXPOSE 8084

# Étape 5 : Définir le point d'entrée pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
