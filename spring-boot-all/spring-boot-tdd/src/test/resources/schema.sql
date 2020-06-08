create table if not exists tb_user(
   id int primary key not null,
   username varchar(20) not null,
   email varchar(10)
);