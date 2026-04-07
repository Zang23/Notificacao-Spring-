# 📌 Sistema de Notificações

API REST desenvolvida em Java com Spring Boot para gerenciamento de mensagens/notificações.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- SQL Server
- Docker
- Gradle

---

## ⚙️ Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/Zang23/Notificacao-Spring-.git
cd SistemaNotificacoes
```

### 2. Suba o banco em Docker

```bash
docker-compose up -d
```

### 3 Configure a aplicacao

Copie: application-example.properties

Renomeie para: application.properties


### 4. Execute a aplicação

```bash
./gradlew bootRun
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
* O banco de dados é criado automaticamente pelo Hibernate e o Docker
* Não é necessário criar tabelas manualmente
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


