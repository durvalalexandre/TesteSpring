CREATE TABLE cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

-- Adicionando a restrição de unicidade para o campo "email"
ALTER TABLE cliente
ADD CONSTRAINT UK_cliente UNIQUE (email);

