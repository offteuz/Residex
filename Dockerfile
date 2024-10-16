# Etapa de Build
FROM maven:3.8.4-jdk-8 AS build

# Copia apenas o pom.xml e baixa as dependências (para cache eficiente)
COPY pom.xml /app/
WORKDIR /app
RUN mvn dependency:go-offline

# Copia o código-fonte depois das dependências já estarem baixadas
COPY src /app/src
RUN mvn clean install -DskipTests -e

# Etapa Final
FROM openjdk:8-jre-alpine

# Copia o JAR gerado na etapa de build para a nova imagem
COPY --from=build /app/target/*.jar /app/app.jar

# Define o diretório de trabalho
WORKDIR /app

# Expondo a porta 8080 (a porta padrão do Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]