-- Instrutores
create table if not exists instrutores (
  id bigserial primary key,
  nome varchar(255) not null,
  email varchar(255) not null unique,
  telefone varchar(20),
  cnh varchar(11) not null unique,
  especialidade varchar(20) not null,
  logradouro varchar(255) not null,
  numero varchar(30),
  complemento varchar(255),
  bairro varchar(120) not null,
  cidade varchar(120) not null,
  uf char(2) not null,
  cep varchar(8) not null,
  ativo boolean not null default true,
  criado_em timestamptz not null default now()
);

-- Alunos
create table if not exists alunos (
  id bigserial primary key,
  nome varchar(255) not null,
  email varchar(255) not null unique,
  telefone varchar(20) not null,
  cpf varchar(11) not null unique,
  logradouro varchar(255) not null,
  numero varchar(30),
  complemento varchar(255),
  bairro varchar(120) not null,
  cidade varchar(120) not null,
  uf char(2) not null,
  cep varchar(8) not null,
  ativo boolean not null default true,
  criado_em timestamptz not null default now()
);

-- Instruções
create table if not exists instrucoes (
  id bigserial primary key,
  aluno_id bigint not null references alunos(id),
  instrutor_id bigint not null references instrutores(id),
  data_hora_inicio timestamp not null,
  data_hora_fim timestamp not null,
  status varchar(20) not null,
  motivo_cancelamento varchar(30),
  cancelada_em timestamp,
  criada_em timestamptz not null default now()
);

create index if not exists idx_instrucao_inicio on instrucoes(data_hora_inicio);
create index if not exists idx_instrucao_status on instrucoes(status);
