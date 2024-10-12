create sequence seq_morador
    nocache
    nocycle
    increment by 1
    start with 1;

create table t_morador
(
    id_morador   integer default seq_morador.nextval,
    nome_morador varchar2(100),
    email        varchar2(60) unique,
    telefone     varchar2(11) unique,
    logradouro   varchar2(100),
    latitude     float,
    longitude    float,
    primary key (id_morador)
);