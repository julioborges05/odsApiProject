create schema if not exists ods;

create table ods.ods (
id bigserial primary key,
objective_number int,
objective_name varchar(100)
);