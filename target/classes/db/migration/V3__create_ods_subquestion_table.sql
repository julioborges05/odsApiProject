create table ods.ods_sub_question (
     id bigserial primary key,
     ods_sub_question varchar,
     status varchar,
     ods_question_number varchar,
     ods_question_id bigint REFERENCES ods.ods_question(id)
);