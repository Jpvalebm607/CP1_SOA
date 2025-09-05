
DO $$
BEGIN
  IF EXISTS (
    SELECT 1 FROM information_schema.columns
    WHERE table_name='alunos' AND column_name='endereco_logradouro'
  ) THEN
    EXECUTE 'ALTER TABLE alunos RENAME COLUMN endereco_logradouro TO logradouro';
  END IF;

  IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name='alunos' AND column_name='endereco_numero') THEN
    EXECUTE 'ALTER TABLE alunos RENAME COLUMN endereco_numero TO numero';
  END IF;

  IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name='alunos' AND column_name='endereco_complemento') THEN
    EXECUTE 'ALTER TABLE alunos RENAME COLUMN endereco_complemento TO complemento';
  END IF;

  IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name='alunos' AND column_name='endereco_bairro') THEN
    EXECUTE 'ALTER TABLE alunos RENAME COLUMN endereco_bairro TO bairro';
  END IF;

  IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name='alunos' AND column_name='endereco_cidade') THEN
    EXECUTE 'ALTER TABLE alunos RENAME COLUMN endereco_cidade TO cidade';
  END IF;

  IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name='alunos' AND column_name='endereco_uf') THEN
    EXECUTE 'ALTER TABLE alunos RENAME COLUMN endereco_uf TO uf';
  END IF;

  IF EXISTS (SELECT 1 FROM information_schema.columns WHERE table_name='alunos' AND column_name='endereco_cep') THEN
    EXECUTE 'ALTER TABLE alunos RENAME COLUMN endereco_cep TO cep';
  END IF;
END $$;


ALTER TABLE alunos
  ADD COLUMN IF NOT EXISTS nome         VARCHAR(255) NOT NULL,
  ADD COLUMN IF NOT EXISTS email        VARCHAR(255) NOT NULL,
  ADD COLUMN IF NOT EXISTS telefone     VARCHAR(20)  NOT NULL,
  ADD COLUMN IF NOT EXISTS logradouro   VARCHAR(255) NOT NULL,
  ADD COLUMN IF NOT EXISTS numero       VARCHAR(20)  NOT NULL,
  ADD COLUMN IF NOT EXISTS complemento  VARCHAR(100),
  ADD COLUMN IF NOT EXISTS bairro       VARCHAR(100) NOT NULL,
  ADD COLUMN IF NOT EXISTS cidade       VARCHAR(100) NOT NULL,
  ADD COLUMN IF NOT EXISTS uf           CHAR(2)      NOT NULL,
  ADD COLUMN IF NOT EXISTS cep          VARCHAR(20)  NOT NULL,
  ADD COLUMN IF NOT EXISTS ativo        BOOLEAN      NOT NULL DEFAULT TRUE;

ALTER TABLE alunos
  ALTER COLUMN uf TYPE CHAR(2),
  ALTER COLUMN nome SET NOT NULL,
  ALTER COLUMN email SET NOT NULL,
  ALTER COLUMN telefone SET NOT NULL,
  ALTER COLUMN logradouro SET NOT NULL,
  ALTER COLUMN numero SET NOT NULL,
  ALTER COLUMN bairro SET NOT NULL,
  ALTER COLUMN cidade SET NOT NULL,
  ALTER COLUMN cep SET NOT NULL;

-- 
DO $$
BEGIN
  IF NOT EXISTS (
    SELECT 1 FROM pg_indexes WHERE tablename='alunos' AND indexname='uk_alunos_email'
  ) THEN
    EXECUTE 'CREATE UNIQUE INDEX uk_alunos_email ON alunos (email)';
  END IF;
END $$;
