create sequence seq_empresa
    nocache
    nocycle
    increment by 1
    start with 1;

create table t_empresa
(
    id_empresa        integer default seq_empresa.nextval,
    CNPJ              varchar2(14) unique,
    razao_social      varchar2(60),
    capacidade_maxima float,
    capacidade_atual  float,
    latitude          float,
    longitude         float,
    primary key (id_empresa)
);