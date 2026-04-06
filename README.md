# 📌 Sistema de Notificações

API REST desenvolvida em Java com Spring Boot para gerenciamento de mensagens/notificações.

---

## 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* SQL Server
* Docker
* Gradle

---

## ⚙️ Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/Zang_23/SistemaNotificacoes.git
cd SistemaNotificacoes
```

---

### 2. Suba o banco com Docker

```bash
docker-compose up -d
```

---

### 3. Configure o application.properties

Crie um arquivo:

```bash
src/main/resources/application.properties
```

Baseado no exemplo:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=notificacao_db
spring.datasource.username=sa
spring.datasource.password=SuaSenhaAqui

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 4. Execute a aplicação

```bash
./gradlew bootRun
```

---

## 📌 Endpoints da API

### 🔹 Criar mensagem

POST /mensagens

### 🔹 Listar mensagens

GET /mensagens

### 🔹 Buscar por ID

GET /mensagens/{id}

### 🔹 Editar mensagem

PUT /mensagens/{id}

### 🔹 Deletar mensagem

DELETE /mensagens/{id}

### 🔹 Listar mensagens não enviadas

GET /mensagens/inativas

---

## 📂 Estrutura do projeto

```
src/
 ├── model        # Entidades
 ├── repository   # Acesso ao banco
 ├── service      # Regras de negócio
 ├── controller   # Endpoints da API
 ├── scheduler    # Agendamento de tarefas
```

---

## 💡 Observações

* O banco de dados é criado automaticamente pelo Hibernate
* Não é necessário criar tabelas manualmente
* O projeto utiliza Docker para facilitar o ambiente

---

## 📌 Melhorias futuras

* Implementar DTOs
* Adicionar validação com Bean Validation
* Criar testes automatizados
* Versionamento de banco com Flyway
* Integrar Angular para o front-end
* Adicionar o Thymeleaf para rodar em server-side

```
```
