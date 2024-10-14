create sequence seq_tipo
    nocache
    nocycle
    start with 1
    increment by 1;

create table t_tipo
(
    id_tipo        integer,
    descricao_tipo varchar2(50),
    primary key (id_tipo)
)