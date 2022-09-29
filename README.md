# transfer-api

API Restful genérica que realiza alguns serviços bancários.

## Funcionalidades
1. No controller de clientes, são realizadas as seguintes operações:
    - Adicionar um novo cliente.
    - Listar todos os clientes cadastrados.
    - Buscar cliente por número da conta.
2. No controller de transferências, são realizadas as seguintes operações:
    - Fazer nova transferência.
    - Listar todas as transferências realizadas.

## Requisitos para execução da aplicação
- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven 4](https://maven.apache.org)

## Executar a aplicação
1. Faça um clone do repositório:
git clone `https://github.com/Roberta-Santos/transfer-api.git`

2. Executar a aplicação utilizando o maven
cd transfer-api
mvn spring-boot:run

A aplicação pode ser acessada em: `http://localhost:8080/swagger-ui/`

## Tecnologias e ferramentas
- Java 11.
- Maven 4.0.0.
- Spring boot 2.7.5-SNAPSHOT.
- Spring Data JPA.
- Spring Web.
- Spring Boot DevTools.
- Swagger 3.
- Log4j.
- Banco de dados H2.
- Lombok.
- git para versionamento de código.
