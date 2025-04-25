ALTER TABLE IF EXISTS consertos ADD COLUMN ativo TINYINT;

UPDATE consertos SET ativo = 1;