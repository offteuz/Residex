create sequence seq_status
    nocache
    nocycle
    increment by 1
    start with 1;

create table t_status
(
    id_status        integer default seq_status.nextval,
    descricao_status varchar2(30),
    primary key (id_status)
);