# transfer-api

API Restful genérica que realiza alguns serviços bancários.

## Funcionalidades
1. No controller de clientes, são realizadas as seguintes operações:
    - Adicionar um novo cliente: Adiciona um novo cliente no banco de dados. Para fazer o cadastro, são necessários os seguintes parâmetros:
        - ID: Long. Gerado automaticamente. Possui valor único.
        - Nome: String. Nome do cliente.
        - Número da conta: String. Número da conta do cliente. Possui valor único.
        - Saldo em conta: float. Saldo da conta.
    - Listar todos os clientes cadastrados: Lista todos os clientes cadastrados previamente no banco de dados. Esse endpoint não possui parâmetros.
    - Buscar cliente por número da conta: Busca um cliente pelo número da conta cadastrado no banco de dados. O único parâmetro para fazer a busca é o número da conta.
2. No controller de transferências, são realizadas as seguintes operações:
    - Fazer nova transferência: Realiza uma transferência entre duas contas. As contas devem estar cadastradas no banco de dados. A conta de origem precisa ter saldo suficiente e o limite máximo por transferência é de R$1000. Para realizar a transferência, são necessários os seguintes parâmetros:
        - ID: Long. Gerado automaticamente. Possui valor único.
        - Conta de origem: String. A conta deve existir no banco de dados.
        - Conta de destino: String. A conta deve existir no banco de dados.
        - Valor: float. Valor a ser transferido.
        - Data da transferência: LocalDate. Data de realização da transferência.
    - Listar todas as transferências realizadas: Lista todas as transferências já realizadas. Esse endpoint não possui parâmetros.

## Requisitos para execução da aplicação
- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven 4](https://maven.apache.org)

## Executar a aplicação
1. Faça um clone do repositório:
    - git clone `https://github.com/Roberta-Santos/transfer-api.git`
2. Executar a aplicação utilizando o maven
    - cd transfer-api
    - mvn spring-boot:run

- A aplicação pode ser acessada em: `http://localhost:8080/swagger-ui/`
- O console do banco de dados pode ser acessado em: `http://localhost:8080/h2`

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
