# Projeto Lab-H2

### _CRUD com Spring Boot, H2 e MyBatis_

Este projeto tem como objetivo exercitar a construção e operação de um banco de dados H2 utilizando Spring Boot e
MyBatis, criando uma API REST para o gerenciamento de pessoas.

## Endereço do Swagger

A documentação da API está disponível via Swagger na seguinte URL:

- [Swagger UI](http://localhost:8080/swagger-ui/index.html#)

## Endpoints Disponíveis

## Pessoas

### **GET /pessoa**

- **Descrição:** Busca uma lista com todas as pessoas registradas.

### **GET /pessoa/{id}**

- **Descrição:** Busca uma pessoa selecionada por Id.

### **GET /pessoa/buscaPorNome**

- **Descrição:** Busca uma lista de pessoas selecionadas por nome.
- **Parametro:** "nome" (query parameter)

### **GET /pessoa/buscaPorBairro**

- **Descrição:** Busca uma lista de pessoas selecionadas por bairro.
- **Parametro:** "bairro" (query parameter)

### **GET /pessoa/buscaPorCidade**

- **Descrição:** Busca uma lista de pessoas selecionadas por cidade.
- **Parametro:** "cidade" (query parameter)

### **GET /pessoa/buscaPorDataNascimentoRange**

- **Descrição:** Busca uma lista de pessoas por intervalo de data de nascimento.
- **Parametro:** "dataInicio, dataFim" (query parameter)

### **POST /pessoa/cadastrar**

```
{
  "nome": "string",
  "idade": 0,
  "email": "string",
  "data_nascimento": "string",
  "endereco": {
    "id": 0
  }
}
```

- **Descrição:** Cadastra uma nova pessoa.

### **PUT /pessoa/{id}**

- **Descrição:** Atualiza as informações de uma pessoas selecionada por Id.

```
{
  "nome": "string",
  "idade": 0,
  "email": "string",
  "data_nascimento": "string",
  "endereco": {
    "id": 0
  }
}
```

### **DELETE /pessoa/{id}**

- **Descrição:** Apaga o registro de uma pessoa selecionada por Id.

## Endereços

### **GET /endereco**

- **Descrição:** Busca uma lista com todos os endereços registrados.

### **GET /endereco/{id}**

- **Descrição:** Busca um endereço selecionado por Id.

### **POST /endereco/cadastrar**

- **Descrição:** Cadastra um endereço.

```
{
  "logradouro": "string",
  "numero": "string",
  "complemento": "string",
  "bairro": "string",
  "cep": "stringst",
  "cidade": "string",
  "estado": "st"
}
```

### **PUT /endereco/{id}**

- **Descrição:** Atualiza um endereço selecionado por Id.

```
{
  "logradouro": "string",
  "numero": "string",
  "complemento": "string",
  "bairro": "string",
  "cep": "stringst",
  "cidade": "string",
  "estado": "st"
}
```

### **DELETE /endereco/{id}**

- **Descrição:** Apaga um endereço selecionado por Id.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- H2 Database (banco de dados em memória para testes)
- MyBatis (framework de persistência)
- Swagger (documentação da API)