-- Criação do Esquema
CREATE SCHEMA IF NOT EXISTS h2dev;

-- Usando o esquema criado
SET SCHEMA h2dev;

-- Criação da Tabela
CREATE TABLE IF NOT EXISTS pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);