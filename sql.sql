create database db;

use db;

create table usuario (
id int not null primary key auto_increment,
usuario char(20),
senha char(20),
noticia char(20) default '');

insert into usuariusuarioo(id,usuario,senha)
values (null,'ana','123');

select * from usuario;