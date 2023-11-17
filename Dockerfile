# Usa a imagem oficial do OpenJDK 17 com Maven como base
FROM maven:3.8.4-openjdk-17-slim

# Configuração do diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Baixa as dependências Maven (apenas o arquivo pom.xml para aproveitar o cache)
RUN mvn dependency:go-offline -B

# Copia o código-fonte para o diretório de trabalho
COPY src ./src

# Compila o código fonte usando o Maven
RUN mvn package -DskipTests

# Especifica o comando padrão para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "target/NutriFit-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080