-- runscript from 'C:/Users/SANTHOSH/eclipse-workspace3/phonebook/src/main/webapp/WEB-INF/views/register.jsp'

drop table users if exists;
drop table contacts if exists;

create table users(
id int primary key auto_increment,
name varchar(50) not null,
email varchar(255) not null unique,
password varchar(255) not null unique,
created_at datetime
);

create table contacts(
id int primary key auto_increment,
firstname varchar(50) not null,
lastname varchar(50) not null,
email varchar(255) not null unique,
phone varchar(100) not null unique,
avatar varchar(50),
address varchar(255),
city varchar(100),
pincode varchar(10),
state varchar(50),
country varchar(50),
user_id int,
created_at datetime,
constraint fk_users foreign key (user_id) references users (id)
)