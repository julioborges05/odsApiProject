create schema if not exists ods;

create table ods.ods (
id bigserial primary key,
objective_number varchar(5),
objective_name varchar(100)
);