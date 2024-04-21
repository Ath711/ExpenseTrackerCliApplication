create table income(
    id int,
    amount int,
    source varchar,
    primary key(id)
);

create table expense(
    id int,
    amount int,
    category varchar,
    date varchar,
    description varchar,
    primary key(id)
);