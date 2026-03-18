# 🚀 CRUD API - Spring Boot

![Java](https://img.shields.io/badge/Java-21-red)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![JWT](https://img.shields.io/badge/Auth-JWT-orange)

API REST desenvolvida em **Java + Spring Boot** para gerenciamento de usuários utilizando autenticação com **JWT** e persistência de dados com **PostgreSQL**.


---

# 📚 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven

---

# 🏗️ Arquitetura do Projeto

O projeto segue uma organização baseada em camadas para manter o código limpo e escalável.

```
src/main/java
│
├── controller     → Endpoints da API
├── service        → Regras de negócio
├── repository     → Comunicação com banco
├── models         → Entidades do sistema
├── dto            → Objetos de transferência
├── security       → Configuração JWT / filtros
└── config         → Configurações do Spring
```

Essa separação melhora:

* manutenção do código
* organização do projeto
* escalabilidade do sistema

---

# ⚙️ Configuração do Projeto

Antes de executar o projeto configure o banco no arquivo:

```
src/main/resources/application.properties
```

Exemplo:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/prometheus
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# ▶️ Como executar o projeto

### 1️⃣ Clonar o repositório

```
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### 2️⃣ Entrar na pasta

```
cd CRUD
```

### 3️⃣ Rodar o projeto

```
./mvnw spring-boot:run
```

Ou execute diretamente pela sua IDE.

---

# 🔐 Autenticação

A API utiliza **JWT para autenticação**.

Fluxo de autenticação:

1. Usuário faz login
2. A API gera um token JWT
3. O token deve ser enviado no header das requisições

```
Authorization: Bearer TOKEN
```

---

# 📡 Endpoints principais

### Usuários

| Método | Endpoint       | Descrição         |
| ------ | -------------- | ----------------- |
| POST   | /usuarios      | Criar usuário     |
| GET    | /usuarios      | Listar usuários   |
| GET    | /usuarios/{id} | Buscar usuário    |
| PUT    | /usuarios/{id} | Atualizar usuário |
| DELETE | /usuarios/{id} | Remover usuário   |

---

# 📦 Estrutura de Entidade (exemplo)

```java
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
}
```

---

# 🧠 Conceitos aplicados

* REST API
* Autenticação JWT
* Spring Security
* JPA / Hibernate
* Arquitetura em camadas
* DTO Pattern
* Repository Pattern

CRUD representa as operações básicas de um banco de dados:

* **Create**
* **Read**
* **Update**
* **Delete**

---

# 📌 Melhorias futuras

* Testes unitários
* Paginação
* Swagger / OpenAPI
* Docker
* Logs estruturados
* Rate Limiting

---

# 👨‍💻 Autor

**João Gilberto Lima Okimura**

GitHub:
https://github.com/Gilberto-Okimura

---

# ⭐ Contribuição

Se este projeto te ajudou, considere dar uma **⭐ no repositório**.
