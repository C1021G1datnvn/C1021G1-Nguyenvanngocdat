create database quanli_diemthi;
use quanli_diemthi;
create table hocsinh(
ma_hs varchar(20)  primary key,
ten_hs varchar(50),
ngay_sinh date,
lop varchar(20),
gioi_tinh varchar(10)
);
create table monhoc(
ma_mh varchar(20) primary key,
ten_mh varchar(20)
);
create table bangdiem(
ma_hs varchar(20), 
ma_mh varchar(20),
diem_thi int,
ngay_kt date,
primary key(ma_hs, ma_mh),
foreign key (ma_hs) references hocsinh(ma_hs),
foreign key (ma_mh) references monhoc(ma_mh)
);
create table giaovien(
ma_gv varchar(20) primary key,
ten_gv varchar(20),
sdt varchar(10)
);
alter table monhoc add ma_gv varchar(20);
alter table monhoc add constraint fk_magiaovien foreign key (ma_gv) references giaovien(ma_gv);