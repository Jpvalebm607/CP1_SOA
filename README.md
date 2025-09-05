# 🚘 AutoEscola API

API REST desenvolvida em **Spring Boot** para gerenciar o agendamento de instruções em uma autoescola.  
Este projeto faz parte do **Checkpoint 1** da disciplina **SOA e WebServices**, ministrada pelo professor **Carlos Eduardo Machado de Oliveira**.

---

## 📚 Objetivo
O objetivo deste checkpoint é aplicar os conceitos iniciais de construção de uma **API REST em Java com Spring Boot**, implementando o **cadastro e listagem de Instrutores e Alunos**, utilizando:
- Classes **DTO**, **VO** e **Entidades**
- Conexão com banco de dados relacional (**JPA/Hibernate**)
- **Validações** de dados (Bean Validation)
- **Controle de migrações** (Flyway ou Liquibase)

---

## 👥 Grupo
- João Pedro Cruz - RM98650
- Tiago Paulino - RM551169
- Victor Eid - RM98668

---


## ⚙️ Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **H2 Database / MySQL / PostgreSQL** (configurável)
- **Flyway / Liquibase** (migrações)
- **Docker Compose** (opcional)

---

## 📌 Endpoints principais

### 👨‍🏫 Instrutores
- **Cadastrar novo instrutor**
  - `POST /instrutores`
  - **Exemplo de JSON (Request Body):**
    ```json
    {
      "nome": "Carlos Silva",
      "cpf": "12345678900",
      "email": "carlos.silva@autoescola.com",
      "telefone": "11987654321"
    }
    ```
  - **Resposta (201 Created):**
    ```json
    {
      "id": 1,
      "nome": "Carlos Silva",
      "cpf": "12345678900",
      "email": "carlos.silva@autoescola.com",
      "telefone": "11987654321"
    }
    ```

- **Listar todos os instrutores**
  - `GET /instrutores`
  - **Resposta (200 OK):**
    ```json
    [
      {
        "id": 1,
        "nome": "Carlos Silva",
        "cpf": "12345678900",
        "email": "carlos.silva@autoescola.com",
        "telefone": "11987654321"
      },
      {
        "id": 2,
        "nome": "Maria Oliveira",
        "cpf": "98765432100",
        "email": "maria.oliveira@autoescola.com",
        "telefone": "11912345678"
      }
    ]
    ```

---

### 👨‍🎓 Alunos
- **Cadastrar novo aluno**
  - `POST /alunos`
  - **Exemplo de JSON (Request Body):**
    ```json
    {
      "nome": "João Pedro",
      "cpf": "12312312312",
      "email": "joao.pedro@autoescola.com",
      "telefone": "11911112222"
    }
    ```
  - **Resposta (201 Created):**
    ```json
    {
      "id": 1,
      "nome": "João Pedro",
      "cpf": "12312312312",
      "email": "joao.pedro@autoescola.com",
      "telefone": "11911112222"
    }
    ```

- **Listar todos os alunos**
  - `GET /alunos`
  - **Resposta (200 OK):**
    ```json
    [
      {
        "id": 1,
        "nome": "João Pedro",
        "cpf": "12312312312",
        "email": "joao.pedro@autoescola.com",
        "telefone": "11911112222"
      },
      {
        "id": 2,
        "nome": "Ana Souza",
        "cpf": "32132132199",
        "email": "ana.souza@autoescola.com",
        "telefone": "11999998888"
      }
    ]
    ```


---

## 🚀 Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/autoescola.git
