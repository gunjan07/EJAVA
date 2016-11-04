use authdb;

create table notes(
    noteid int not null auto_increment primary key,
   	title varchar(32) not null,
    category varchar(32) not null,
    content mediumtext,
    note_date datetime not null,
    userid varchar(32) not null,
    constraint fk_userid foreign key (userid) references users(userid)  
) engine=InnoDB default charset=utf8;

