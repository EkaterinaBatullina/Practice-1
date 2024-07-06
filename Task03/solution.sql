select name from Passenger;

select name from Company;

select * from Trip where town_from = 'Moscow';

select name
from Passenger
where name like '%man';

select count(*) as count
from Trip
where plane = 'TU-134';

select name
from company
where id in (select company from trip where plane = "Boeing");


select distinct plane
from Trip
where town_to = 'Moscow';

select town_to, time(time_in - time_out) as flight_time
from Trip
where town_from = 'Paris';

select c.name
from company c
where c.id in (select distinct t.company from trip t where t.town_from = "Vladivostok");

select *
from Trip
where time_out >= "19000101100000"
  and time_out <= "19000101140000";


select name
from Passenger
where length(name) = (
select max(length(name))
from Passenger);

select p.trip as trip, count(p.passenger) as count
from Pass_in_trip as p
join Passenger as pa on p.passenger = pa.id group by p.trip;

select a.name
from (select b.name, count(b.name) as count from Passenger b group by b.name) as a
where a.count > 1;

select town_to
from Trip t
where t.id in (select pit.trip
             from Pass_in_trip pit
             where pit.passenger in (select p.id
                                 from Passenger p
                                 where p.name = 'Bruce Willis'));

select t.time_in
from trip t
where t.id in
      (select pit.trip
       from pass_in_trip pit
       where pit.passenger in
             (select p.id
              from passenger p
              where p.name = "Steve Martin"))
  and town_to = 'London';

select p.name, query.count
from (select pit.passenger, count(pit.passenger) as count
      from pass_in_trip pit
      group by pit.passenger) query,
     passenger p
where p.id = query.passenger
order by query.count desc, p.name;

select fm.member_name, fm.status, query.costs
from FamilyMembers fm,
     (select sum (p.amount*p.unit_price) as costs, p.family_member
      from Payments p
      where p.date >= "2005:01:01:00:00:00" and p.date < "2006.01.01:00:00:00"
      group by p.family_member) query
where query.costs > 0 and query.family_member = fm.member_id;

select fm.status
from FamilyMembers fm
where fm.member_id in
      (select p.family_member
       from Payments p
       where p.good in
             (select g.good_id
              from Goods g
              where g.good_name = 'potato'));

select fm.status, fm.member_name, query.costs
from FamilyMembers fm,
     (select p.family_member, sum(p.amount*p.unit_price) as costs
      from Payments p
      where p.good in
            (select g.good_id
             from Goods g
             where g.type in
                   (select gt.good_type_id
                    from GoodTypes gt
                    where gt.good_type_name = 'entertainment'))
      group by p.family_member) query
where fm.member_id = query.family_member;

select g.good_name
from Goods g,
     (select p.good, count(p.good) as count
      from Payments p group by good) query
where query.count > 1 and query.good = g.good_id;

select member_name
from FamilyMembers
where status = 'mother';

select g.good_name, p.unit_price
from Goods g, Payments p
where g.good_id = p.good and p.unit_price =
                             (select max(p.unit_price)
                              from Payments p
                              where p.good in
                                    (select g.good_id
                                     from Goods g
                                     where g.type in
                                           (select gt.good_type_id
                                            from GoodTypes gt
                                            where gt.good_type_name = 'delicacies')));

select fm.member_name, query.costs
from FamilyMembers fm,
     (select p.family_member, sum(p.amount * p.unit_price) as costs
      from Payments p
      where p.date >= "2005:06:01:00:00:00" and p.date < "2005:07:01:00:00:00"
      group by p.family_member) query
where query.family_member = fm.member_id;

select g.good_name
from Goods g
where g.good_id not in
      (select p.good
       from Payments p
       where p.date >= "2005:01:01:00:00:00" and p.date < "2006:01:01:00:00:00");

select distinct gt.good_type_name
from GoodTypes gt
where gt.good_type_id not in
      (select g.type
       from Goods g
       where g.good_id in
             (select p.good
              from Payments p
              where p.date >= "2005:01:01" and p.date < "2006:01:01"));

select good_type_name, q.costs
from (select type, sum(amount * unit_price) as costs
      from Payments
               left join goods on good = good_id
      where date >= "2005:01:01"
        and date < "2006:01:01"
      group by type) q
         left join goodtypes on q.type = good_type_id;

select count(*) as count
from Trip
where town_from = "Rostov" and town_to = "Moscow";

select p.name
from Passenger p
where p.id in
      (select pit.passenger
       from Pass_in_trip pit
       where pit.trip in
             (select t.id
              from Trip t
              where t.town_to = "Moscow" and t.plane = "TU-134"));

select pit.trip, count (pit.passenger) as count
from Pass_in_trip pit
group by pit.trip order by count desc;
