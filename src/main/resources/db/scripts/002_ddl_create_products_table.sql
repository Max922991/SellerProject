create table if not exists products(
id serial primary key,
title varchar(255) not null,
description varchar(255) not null,
price int not null
);