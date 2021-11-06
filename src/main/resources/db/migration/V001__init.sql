create table customer (
id bigint not null auto_increment,
name varchar(100) not null,
document varchar(100) not null,
constraint pk_customer primary key (id),
unique(document)
)engine=InnoDB default charset=utf8;

create table address (
id bigint not null auto_increment,
street varchar(100) not null,
city varchar(100) not null,
zip_code varchar(20) not null,
number varchar(20) not null,
geoCode varchar(100) not null,
id_customer bigint not null,
constraint pk_address primary key (id),
constraint fk_customer foreign key (id_customer) references customer (id),
unique(geoCode)
)engine=InnoDB default charset=utf8;