CREATE TABLE tb_worker(

    id bigint not null auto_increment,
    name varchar(200) not null,
    daily_Income double not null,
    ativo boolean not null,
    primary key (id)

)