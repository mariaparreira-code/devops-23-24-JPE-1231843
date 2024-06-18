# Use a imagem base oficial do OpenJDK para Java 11
FROM openjdk:21-jdk-slim as builder

# Cria um diretório para a aplicação
WORKDIR /CA5

# Copia o arquivo JAR gerado pelo Gradle para o diretório de trabalho no contêiner
COPY CA2.Part2/demoWithGradle/build/libs/*.jar app.jar

# Define o comando padrão para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]

