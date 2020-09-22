drop user 'user'@'localhost';

drop schema vagas;

create schema vagas;

use vagas;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on vagas.* to user@'localhost';

create table usu_usuario (
	usu_id bigint unsigned primary key auto_increment,
	usu_nome_usuario varchar(50) not null,
	usu_senha varchar(50) not null,
	constraint usu_nome_usuario_uk unique (usu_nome_usuario)
);

create table emp_empresa (
	emp_id bigint unsigned primary key,
	emp_cnpj varchar(14) not null,
	emp_nome_fantasia varchar(50) not null,
	emp_responsavel varchar(100) not null,
	emp_telefone varchar(15) not null,
	constraint emp_usu_fk foreign key(emp_id)
		references usu_usuario(usu_id)
);

create table vag_vagas (
	vag_id bigint unsigned primary key,
	vag_cargo varchar(50) not null,
	vag_descricao varchar(500) not null,
	vag_status varchar(10) not null,
	emp_id bigint unsigned,
	constraint vag_emp_fk foreign key (vag_id)
	references emp_empresa (emp_id)
);

create table end_endereco (
	end_id bigint unsigned primary key,
	end_tipo varchar(10) not null,
	end_tipo_descricao varchar(50),
	end_numero varchar(10),
	end_cidade varchar(20),
	end_estado varchar(20),
	end_pais varchar(20),
	constraint end_emp_fk foreign key (end_id)
	references emp_empresa (emp_id)
);