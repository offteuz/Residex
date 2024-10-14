create sequence seq_recipiente
    nocache
    nocycle
    increment by 1
    start with 1;

create table t_recipiente
(
    id_recipiente     integer default seq_recipiente.nextval,
    tipo_residuo      varchar2(50),
    capacidade_maxima float,
    capacidade_atual  float,
    latitude          float,
    longitude         float,
    id_morador        integer,
    id_tipo           integer,
    primary key (id_recipiente),
    constraint fk_morador_recipiente foreign key (id_morador) references t_morador (ID_MORADOR),
    constraint fk_tipo_recipiente foreign key (id_tipo) references t_tipo(ID_TIPO)
);