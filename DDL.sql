create schema vagas;

use vagas;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on vagas.* to user@'localhost';

create table emp_empresa (
	emp_id bigint unsigned primary key auto_increment,
	emp_cnpj varchar(14) not null,
	emp_nome_fantasia varchar(50) not null,
	emp_responsavel varchar(100) not null,
	emp_telefone varchar(15) not null
);
create table con_conta_usuario (
	con_id bigint unsigned primary key auto_increment,
	con_nome_usuario varchar(50) not null,
	con_senha varchar(50) not null,
	emp_id bigint unsigned,
	constraint con_emp_fk foreign key (emp_id)
	references emp_empresa(emp_id),
	constraint con_emp_id_uk unique (emp_id)
);
create table vag_vagas (
	vag_id bigint unsigned primary key auto_increment,
	vag_cargo varchar(50) not null,
	vag_descricao varchar(500) not null,
	vag_status varchar(10) not null,
	emp_id bigint unsigned,
	constraint vag_emp_fk foreign key (emp_id)
	references emp_empresa (emp_id)
);

create table end_endereco (
	end_id bigint unsigned primary key auto_increment,
	emp_id bigint unsigned,
	end_tipo varchar(10) not null,
	end_tipo_descricao varchar(50),
	end_numero varchar(10),
	end_cidade varchar(20),
	end_estado varchar(20),
	end_pais varchar(20),
	constraint end_emp_fk foreign key (emp_id)
	references emp_empresa (emp_id)
);