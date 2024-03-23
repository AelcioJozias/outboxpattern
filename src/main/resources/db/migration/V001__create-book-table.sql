CREATE TABLE IF NOT EXISTS book(
id SERIAL PRIMARY KEY ,
uuid varchar(36) NOT NULL ,
title varchar(100),
description varchar(255) NOT NULL,
year timestamp with time zone not null
);