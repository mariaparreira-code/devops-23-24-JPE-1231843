# Use a imagem base oficial do OpenJDK para Java 11
FROM openjdk:17-jre-slim

# Cria um diretório para a aplicação
WORKDIR /CA5

# Copia o arquivo JAR gerado pelo Gradle para o diretório de trabalho no contêiner
COPY CA2.Part2/demoWithGradle/build/libs/*.jar /CA5

# Expõe a porta que o Spring Boot usa
EXPOSE 8080

# Define o comando padrão para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]

