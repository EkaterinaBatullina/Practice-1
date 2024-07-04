drop table if exists student_course;
drop table if exists lesson;
drop table if exists course;
drop table if exists student;

create table student (
                         id serial primary key,
                         first_name char(20) not null,
                         last_name char(20) not null,
                         age integer check (age >= 18 and age < 120)
);

alter table student add email char(20) unique;

create table course (
                        id serial primary key,
                        title char(20),
                        description char(100),
                        start_date date,
                        finish_date date
);

--многие к одному - много уроков к одному курсу
create table lesson (
                        id serial primary key,
                        name char(20),
                        start_time time,
                        finish_time time,
                        day_of_week char(20),
                        course_id integer,
                        foreign key (course_id) references course(id)
);

--многие ко многим - между студентами и курсами
create table student_course(
                               student_id integer,
                               course_id integer,
                               foreign key (student_id) references student(id),
                               foreign key (course_id) references course(id)
);