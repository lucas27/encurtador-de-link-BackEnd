FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

ARG DB_NAME
ARG DATABASE_USERNAME
ARG DATABASE_PASSWORD

ENV DB_NAME=$DB_NAME
ENV DATABASE_USERNAME=$DATABASE_USERNAME
ENV DATABASE_PASSWORD=$DATABASE_PASSWORD

# Copia os arquivos do projeto e baixa as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código-fonte e faz a build gerando o .jar
COPY src ./src
RUN mvn clean package -DskipTests

# ESTÁGIO 2: Montar a imagem final para rodar a aplicação
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia o .jar gerado no estágio anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta da sua aplicação (ajuste se necessário)
EXPOSE 8080
# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]