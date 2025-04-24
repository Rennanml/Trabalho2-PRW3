DROP TABLE IF EXISTS concertos;

CREATE TABLE concertos(
                          id bigint not null auto_increment,
                          data_entrada varchar(20) not null,
                          data_saida varchar(20) not null,
                          mecanico_responsavel_codigo varchar(20) not null,
                          mecanico_responsavel_nome varchar(100) not null,
                          mecanico_responsavel_anos_experiencia int not null,
                          veiculo_placa varchar(15) not null,
                          veiculo_marca varchar(50) not null,
                          veiculo_modelo varchar(50) not null,
                          veiculo_ano varchar(4) not null,

                          PRIMARY KEY (id)
);
