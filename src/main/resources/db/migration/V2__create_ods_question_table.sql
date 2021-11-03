create table ods.ods_question (
     id bigserial primary key,
     ods_question varchar,
     ods_question_number varchar,
     ods_id bigint REFERENCES ods.ods(id)
);