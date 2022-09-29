# transfer-api

API Restful genérica que realiza alguns serviços bancários.

## Funcionalidades
1. No controller de clientes, são realizadas as seguintes operações:
1.1. Adicionar um novo cliente.
1.2. Listar todos os clientes cadastrados.
1.3. Buscar cliente por número da conta.
2. No controller de transferências, são realizadas as seguintes operações:
2.1. Fazer nova transferência.
2.2. Listar todas as transferências realizadas.

## Requisitos para execução da aplicação
- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven 4](https://maven.apache.org)

## Executar a aplicação
1. Faça um clone do repositório:
git clone https://github.com/Roberta-Santos/transfer-api.git

2. Executar a aplicação utilizando o maven**
cd transfer-api
mvn spring-boot:run

A aplicação pode ser acessada em: http://localhost:8080/swagger-ui/

## Tecnologias e ferramentas
1. Java 11.
2. Maven 4.0.0.
3. Spring boot 2.0.2-SNAPSHOT.
4. Spring Data JPA.
5. Spring Web.
6. Spring Boot DevTools.
7. Swagger 3.
8. Log4j.
9. Banco de dados H2.
10. Lombok.
11. git para versionamento de código.
