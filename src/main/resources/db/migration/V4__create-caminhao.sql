create sequence seq_caminhao
    nocache
    nocycle
    increment by 1
    start with 1;

create table t_caminhao
(
    id_caminhao integer default seq_caminhao.nextval,
    modelo      varchar2(100),
    placa       varchar2(7) unique,
    em_rota     char(1),
    capacidade_maxima float,
    capacidade_atual float,
    latitude    float,
    longitude   float,
    id_empresa  integer,
    primary key (id_caminhao),
    constraint fk_empresa_caminhao foreign key (id_empresa) references t_empresa (ID_EMPRESA)
);