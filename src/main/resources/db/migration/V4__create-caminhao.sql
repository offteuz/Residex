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
    latitude    float,
    longitude   float,
    id_status      integer,
    id_empresa     integer,
    primary key (id_caminhao),
    constraint fk_status foreign key (id_status) references t_status (ID_STATUS),
    constraint fk_empresa foreign key (id_empresa) references t_empresa (ID_EMPRESA)
);