create database projetodb;

\c database_serasa

create table user (
    id serial not null PRIMARY KEY,
    name varchar(100) not null,
    cpf varchar(20) not null,
    email varchar(50) not null,
    phone_number varchar(15) null,    
    created_at timestamp not null default current_timestamp,
    update_at timestamp null default current_timestamp    
);