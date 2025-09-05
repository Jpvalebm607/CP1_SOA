   
ALTER TABLE instrutores
    ALTER COLUMN uf TYPE varchar(2);


DO $$
BEGIN
    IF EXISTS (SELECT 1 FROM information_schema.columns
               WHERE table_name = 'alunos' AND column_name = 'uf') THEN
        EXECUTE 'ALTER TABLE alunos ALTER COLUMN uf TYPE varchar(2)';
    END IF;
END $$;
