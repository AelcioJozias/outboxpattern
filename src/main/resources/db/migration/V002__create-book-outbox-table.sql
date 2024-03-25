CREATE TABLE IF NOT EXISTS book_outbox(
                                         id uuid PRIMARY KEY ,
                                         title varchar(100),
                                         description varchar(255) NOT NULL,
                                         year timestamp without time zone not null,
                                         transaction_status varchar(20) not null
);