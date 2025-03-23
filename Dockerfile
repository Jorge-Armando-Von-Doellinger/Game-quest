# Usa OpenJDK 23
FROM openjdk:23-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia arquivos essenciais primeiro
COPY gradlew ./
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./


RUN chmod +x gradlew


RUN java -version


RUN ./gradlew dependencies --no-daemon
COPY . .

EXPOSE ${SERVERPORT}
RUN ./gradlew clean build -x test

CMD ["java", "-jar", "build/libs/game-quest-0.0.1-SNAPSHOT.jar"]
