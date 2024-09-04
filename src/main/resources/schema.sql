-- Criação do Esquema
CREATE SCHEMA IF NOT EXISTS h2dev;

-- Usando o esquema criado
SET SCHEMA h2dev;

-- Criação da tabela de endereços
CREATE TABLE IF NOT EXISTS endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(255),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    cep VARCHAR(255) NOT NULL,
    cidade VARCHAR(255 NOT NULL),
    estado VARCHAR(2) NOT NULL -- Estado em formato de sigla
);

-- Criação da tabela de pessoas
CREATE TABLE IF NOT EXISTS pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL
);