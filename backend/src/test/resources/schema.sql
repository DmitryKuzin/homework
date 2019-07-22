drop table if exists salary;

create table salary
(
	summ bigint not null,
	id bigserial not null
		constraint salary_pk
			primary key
)
;