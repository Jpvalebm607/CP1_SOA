CREATE TABLE IF NOT EXISTS alunos (
    id           BIGSERIAL PRIMARY KEY,
    nome         VARCHAR(120)  NOT NULL,
    email        VARCHAR(150)  NOT NULL UNIQUE,
    telefone     VARCHAR(20)   NOT NULL,

    -- Endereco embutido (@Embedded)
    logradouro   VARCHAR(120)  NOT NULL,
    numero       VARCHAR(20)   NOT NULL,
    complemento  VARCHAR(60),
    bairro       VARCHAR(80)   NOT NULL,
    cidade       VARCHAR(80)   NOT NULL,
    uf           VARCHAR(2)    NOT NULL,
    cep          VARCHAR(20)   NOT NULL,

    ativo        BOOLEAN       NOT NULL DEFAULT TRUE
);
