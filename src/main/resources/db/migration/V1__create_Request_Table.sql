Create table Request
(Id IDENTITY NOT NULL PRIMARY KEY, request varchar (255),
    local_date_time timestamp ,
    index int,
    region varchar(255),
    city varchar(255),
    settlement varchar(255),
    street varchar(255),
    house varchar(255));