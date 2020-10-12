drop table if exists games;

create table games (
id bigserial primary key,
name text,
description text,
price numeric(12,2)
);

insert into games (name, description, price) values
('Skyrim', 'But it', 99.99),
('TheWitcher3', 'Play it', 50),
('Fallout76', 'Just skip it', 100);