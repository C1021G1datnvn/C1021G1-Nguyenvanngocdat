use my_student;
create table class(
idClass int not null primary key, 
nameClass varchar(45)
);
create table teacher(
idTeacher int not null primary key, 
nameTeacher varchar(45),
age int,
country varchar(45)
);