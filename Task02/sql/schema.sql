drop table if exists client;
drop table if exists driver;
drop table if exists auto;
drop table if exists "order";

create table client(
                       id serial primary key,
                       first_name char(20) not null,
                       last_name char(20) not null
);

alter table client add age integer check (age >= 7 and age < 120);

create table driver(
                       id serial primary key,
                       first_name char(20) not null,
                       last_name char(20) not null
);

alter table driver add experience integer check (experience >=0 and experience < 100);

create table auto(
                     name char(20) not null,
                     number char(6),
                     driver_id integer,
                     foreign key (driver_id) references driver(id)
);

create table "order"(
                          start_time time,
                          client_id integer,
                          driver_id integer,
                          foreign key (client_id) references client(id),
                          foreign key (driver_id) references driver(id)
);
