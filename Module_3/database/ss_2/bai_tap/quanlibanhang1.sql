create database quanli_banhang;
use quanli_banhang;
create table customer(
cID int not null primary key auto_increment,
cName varchar(50),
cAge int
);
create table `order`(
oID int not null primary key auto_increment,
cID int,
oDate date,
oTotalPrice double,
foreign key (cID) references customer(cID)
);
create table product(
pID int not null primary key auto_increment,
pName varchar(50),
pPirce double
);
create table orderDetail(
oID int, 
pID int,
odQTY varchar(50),
foreign key(oID) references `order`(oID),
foreign key(pID) references product(pID)
);