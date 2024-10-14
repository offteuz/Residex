create sequence seq_notificacao
    nocache
    nocycle
    start with 1
    increment by 1;

create table t_notificacao
(
    id_notificacao        integer default seq_notificacao.nextval,
    descricao_notificacao varchar2(200),
    data_coleta           date,
    id_morador            integer,
    id_recipiente         integer,
    primary key (id_notificacao),
    constraint fk_morador_notificao foreign key (id_morador) references t_morador (ID_MORADOR),
    constraint fk_recipiente_notificacao foreign key (id_recipiente) references t_recipiente (ID_RECIPIENTE)
);