# ESTÁGIO 1: Compilação (Build)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

# Define o diretório de trabalho dentro do container de build
WORKDIR /app

# Copia apenas o pom.xml primeiro para baixar as dependências
COPY pom.xml .

# Baixa as dependências SEM compilar o código
RUN mvn dependency:resolve-plugins dependency:resolve -B

# Agora copia o código fonte e compila o projeto pulando os testes
COPY src ./src
RUN mvn clean package -DskipTests

# ESTÁGIO 2: Execução (Runtime)
# Usamos uma imagem JRE (muito menor) apenas para rodar a aplicação
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia APENAS o arquivo .jar gerado no primeiro estágio
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
# Como sua aplicação é interativa, o ENTRYPOINT continua o mesmo
ENTRYPOINT ["java", "-jar", "app.jar"]