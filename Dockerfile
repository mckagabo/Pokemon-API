FROM eclipse-temurin:17
#WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY target/petal-pokemons-0.0.1-SNAPSHOT.jar petal-pokemons.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/petal-pokemons.jar"]