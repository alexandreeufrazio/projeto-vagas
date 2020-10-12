--drop user 'user'@'localhost';

--drop schema vaga;

create schema vaga;

use vaga;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on vaga.* to user@'localhost';

create table emp_empresa (
	emp_id bigint unsigned primary key auto_increment,
	emp_razao_social varchar(50) not null,
	emp_senha varchar(50) not null,
	constraint emp_razao_social_uk unique (emp_razao_social)
);
create table usu_usuario (
	usu_id bigint unsigned primary key auto_increment,
	usu_nome_usuario varchar(50) not null,
	alu_senha varchar(50) not null,
	constraint usu_nome_usuario_uk unique (usu_nome_usuario)	
);
create table vag_vaga (
	vag_id bigint unsigned primary key auto_increment,
	vag_descricao varchar(200) not null,
	emp_anunciante_id bigint unsigned,
	constraint vag_emp_fk foreign key (emp_anunciante_id)
	references emp_empresa (emp_id)
);
create table anu_anuncio (
	usu_id bigint unsigned,
	emp_id bigint unsigned,
	primary key (usu_id, emp_id),
	constraint anu_usu_fk foreign key (usu_id)
	references usu_usuario (usu_id),
	constraint anu_emp_fk foreign key (emp_id)
	references emp_empresa (emp_id)
);
