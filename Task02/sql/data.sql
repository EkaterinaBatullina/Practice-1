insert into client (first_name, last_name, age)
values('Marat', 'Hafizov', 30),
      ('Maria','Nikolaeva', 25),
      ('Ayrat', 'Sidikov', 41);

update client set age = 31 where id = 2;

insert into driver (first_name, last_name, experience)
values('Marsel', 'Zaripov', 7),
      ('Anna','Safina', 12),
      ('Aleksey', 'Galimov', 10);

update driver set experience = 8 where id = 2;

insert into auto (name, number, driver_id)
values('Kia', 'к724уу', 1),
      ('Ford', 'о814ое', 2),
      ('Toyota', 'е432ех', 3);

insert into "order" (start_time, client_id, driver_id)
values('09:45:17', 3, 1),
      ('12:30:00', 2, 2),
      ('20:11:56', 1, 3);
