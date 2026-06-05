# 🔗 Encurtador de URLs (URL Shortener)

Projeto desenvolvido individualmente com o objetivo de consolidar conceitos fundamentais do ecossistema Java, desenvolvimento de APIs REST com Spring Boot e testes.

## 🛠️ Tecnologias Utilizadas

- **Java 17** 
- **Spring Boot 4**
- **Spring Web** (MVC)
- **Spring Data JPA**
- **Banco de dados Postgres**
- **Github action**
- **Docker**
- **Junit**
- **Swagger**

## ⚙️ Como Funciona a API

### 1. Criar um link encurtador exemplo:
`POST /url`
- **Payload:** `{ "urlOriginal": "https://exemplo.com.br..." }`
- **Retorno:** Código identificador (ex: `http://.../xyz123`)

### 2. Redirecionar Usuário
`GET /{codigo}`
- Redireciona o navegador automaticamente para o site de destino usando o protocolo correto (`http://` ou `https://`).

## 💻 Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/lucas27/encurtador-de-link-BackEnd.git
   ```
2. Modifique o application.properties com o user e password do BD postgress
    ```
    spring.datasource.url=jdbc:postgresql://${DB_NAME}:5432/${DB_NAME}
    spring.datasource.username=DATABASE_USERNAME
    spring.datasource.password=DATABASE_PASSWORD
    ```
3. A aplicação estará disponível em `http://localhost:8080`.