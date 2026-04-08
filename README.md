# 📌 Sistema de Notificações

API REST desenvolvida em Java com Spring Boot para gerenciamento de mensagens/notificações.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- SQL Server
- Docker & Docker Compose
- Gradle
- Thymeleaf (para visualização simples

---

## ⚙️ Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/Zang23/Notificacao-Spring-.git
cd Notificacao-Spring
```

### 2. Suba o banco em Docker

2.1. Rodar o container
docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=SuaSenhaForte123" \
-p 1433:1433 --name sqlserver \
-d mcr.microsoft.com/mssql/server:2022-latest

2.2 Acessar o container
docker exec -it sqlserver /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P SuaSenhaForte123

2.3 Criar o banco de dados

Dentro do SQL Server:

CREATE DATABASE notificacao_db;
GO

### 3 Configure a aplicacao

```bash
Copie: application-example.properties

Renomeie para: application.properties

No arquivo application.properties:

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=notificacao_db;encrypt=false;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=SuaSenhaForte123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Execute a aplicação

```bash
./gradlew bootRun

Acessando aplicacao: http://localhost:8080/mensagens
```
### Endpoints da API

| Método | Rota                | Descrição                     |
| ------ | ------------------- | ----------------------------- |
| POST   | /mensagens          | Criar mensagem                |
| GET    | /mensagens          | Listar mensagens              |
| GET    | /mensagens/{id}     | Buscar por ID                 |
| PUT    | /mensagens/{id}     | Editar mensagem               |
| DELETE | /mensagens/{id}     | Deletar mensagem              |
| GET    | /mensagens/inativas | Listar mensagens não enviadas |

### Estrutura do projeto

```
src/
 ├── model        # Entidades
 ├── repository   # Acesso ao banco
 ├── service      # Regras de negócio
 ├── controller   # Endpoints da API
 ├── scheduler    # Agendamento de tarefas
 ```

### Observações
* O banco de dados não é criado automaticamente pelo Hibernate e o Docker
* É necessario criar o banco de dados quando iniciar o docker
* O Docker é utilizado para facilitar a configuração e execução do ambiente

### Decisões técnicas
* A escolha do SQL Server foi feita com fins educacionais. Em cenários reais, especialmente em aplicações com alto volume de mensagens, bancos de dados não relacionais podem ser mais adequados em termos de performance e escalabilidade.
* O uso do Docker aproxima o projeto das práticas modernas utilizadas no mercado, além de simplificar o setup do ambiente.

### Melhorias futuras
* Implementar DTOs
* Adicionar validação com Bean Validation
* Criar testes automatizados
* Versionamento de banco com Flyway
* Integração com Angular (front-end)


