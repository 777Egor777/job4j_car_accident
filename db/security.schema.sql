create table users(
    username varchar(50) not null,
    password varchar(100) not null,
    enabled boolean default true,
    primary key (username)
);

create table authorities(
    username varchar(50) not null references users,
    authority varchar(50) not null
);