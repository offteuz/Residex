create sequence seq_item
    nocycle
    nocache
    start with 1
    increment by 1;

create table t_item
(
    id_item        integer,
    descricao_item varchar2(100),
    peso_item      float,
    id_recipiente  integer,
    id_tipo        integer,
    primary key (id_item),
    constraint fk_recipiente_item foreign key (id_recipiente) references t_recipiente (ID_RECIPIENTE),
    constraint fk_tipo_item foreign key (id_tipo) references t_tipo (ID_TIPO)
);