# Etapa de Build
FROM maven:3.8.4-openjdk-17 AS build

# Cria um diretório para a aplicação
WORKDIR /app

# Copia apenas o pom.xml e baixa as dependências (para cache eficiente)
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copia o código-fonte depois das dependências já estarem baixadas
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa Final
FROM openjdk:17-jdk-alpine

# Copia o JAR gerado na etapa de build para a nova imagem
COPY --from=build /app/target/*.jar /app/app.jar

# Define o diretório de trabalho
WORKDIR /app

ENV PROFILE=prd

# Expondo a porta 8080 (a porta padrão do Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]