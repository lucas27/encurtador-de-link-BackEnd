# 🔗 Encurtador de URLs (URL Shortener)

Projeto desenvolvido individualmente com o objetivo de consolidar conceitos fundamentais do ecossistema Java e desenvolvimento de APIs REST com Spring Boot.

## 🛠️ Tecnologias Utilizadas

- **Java 17** (ou a versão que usou)
- **Spring Boot 3.x**
- **Spring Web** (MVC)
- (Opcional: Spring Data JPA / Banco de dados Postgres)

## ⚙️ Como Funciona a API

### 1. Criar um link encurtador exemplo:
`POST /app/link`
- **Payload:** `{ "urlOriginal": "https://exemplo.com.br..." }`
- **Retorno:** Código identificador (ex: `http://.../app/link/xyz123`)

### 2. Redirecionar Usuário
`GET /app/link/{codigo}` ou `GET /app/link/redirecionar?url=...`
- Redireciona o navegador automaticamente para o site de destino usando o protocolo correto (`http://` ou `https://`).

## 💻 Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com
   ```
2. Modifique o application.properties com o user e password do BD postgress
    ```
    spring.datasource.username=DATABASE_USERNAME
    spring.datasource.password=DATABASE_PASSWORD
    ```
3. A aplicação estará disponível em `http://localhost:8080`.