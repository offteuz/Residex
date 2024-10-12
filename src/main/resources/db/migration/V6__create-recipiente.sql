create sequence seq_recipiente
    nocache
    nocycle
    increment by 1
    start with 1;

create table t_recipiente
(
    id_recipiente     integer default seq_recipiente.nextval,
    tipo_residuo      varchar2(50),
    capacidade_atual  float,
    capacidade_maxima float,
    id_morador        integer,
    latitude          float,
    longitude         float,
    primary key (id_recipiente),
    constraint fk_morador foreign key (id_morador) references t_morador (ID_MORADOR)
);