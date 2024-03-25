CREATE TABLE IF NOT EXISTS book(
id uuid PRIMARY KEY ,
title varchar(100),
description varchar(255) NOT NULL,
year timestamp without time zone not null
);