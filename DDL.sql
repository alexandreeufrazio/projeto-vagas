 --drop user 'user'@'localhost';

 --drop schema vaga;

create schema vaga;

use vaga;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on vaga.* to user@'localhost';

create table cont_conta (
    cont_id bigint unsigned primary key auto_increment,
    cont_nome_usuario varchar(50) not null,
    cont_senha varchar(50) not null,
    constraint cont_nome_usuario_uk unique (cont_nome_usuario)	
);

create table emp_empresa (
	emp_id bigint unsigned primary key,
	emp_razao_social varchar(50) not null,
	constraint emp_razao_social_uk unique (emp_razao_social),
        constraint emp_cont_fk foreign key (emp_id)
           references cont_conta(cont_id)
);
create table usu_usuario (
	usu_id bigint unsigned primary key,
	constraint usu_cont_fk foreign key (usu_id)
           references cont_conta(cont_id)	
);
create table vag_vaga (
	vag_id bigint unsigned primary key auto_increment,
	vag_descricao varchar(200) not null,
	emp_anunciante_id bigint unsigned,
	constraint vag_emp_fk foreign key (emp_anunciante_id)
	references emp_empresa (emp_id)
);
create table ace_acesso (
	usu_id bigint unsigned,
	vag_id bigint unsigned,
	primary key (usu_id, vag_id),
	constraint ace_usu_fk foreign key (usu_id)
	references usu_usuario (usu_id),
	constraint ace_vag_fk foreign key (vag_id)
	references vag_vaga (vag_id)
);
