# Projeto Lab-H2
### _CRUD com Spring Boot, H2 e MyBatis_

Este projeto tem como objetivo exercitar a construção e operação de um banco de dados H2 utilizando Spring Boot e MyBatis, criando uma API REST para o gerenciamento de pessoas.

## Endereço do Swagger
A documentação da API está disponível via Swagger na seguinte URL:
- [Swagger UI](http://localhost:8080/swagger-ui/index.html#)

## Endpoints Disponíveis

### **GET /pessoas**
- **Descrição:** Busca uma lista com todas as pessoas registradas.
### **GET /pessoas/{id}**
- **Descrição:** Busca uma pessoa pelo Id.
### **GET /pessoa/buscaPorNome**
- **Descrição:** Busca uma lista de pessoas selecionadas por nome.
- **Parametro:** "nome" (query parameter)
### **POST /pessoa/cadastrar**
- **Descrição:** Cadastra uma nova pessoa.
### **PUT /pessoa/{id}**
- **Descrição:** Atualiza as informações de uma pessoas selecionada por Id.
### **DELETE /pessoa/{id}**
- **Descrição:** Apaga o registro de uma pessoa selecionada por Id.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- H2 Database (banco de dados em memória para testes)
- MyBatis (framework de persistência)
- Swagger (documentação da API)