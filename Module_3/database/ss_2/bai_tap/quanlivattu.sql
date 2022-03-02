create database quanli_vattu;
use quanli_vattu;
create table phieu_xuat(
so_phieuxuat int primary key,
ngay_xuat date

);
create table vat_tu(
ma_vattu varchar(20) primary key,
ten_vattu varchar(50)
);
create table chitiet_phieuxuat(
dongia_xuat varchar(20),
soluong_xuat int,
so_phieuxuat int,
ma_vattu varchar(20),
foreign key (so_phieuxuat) references phieu_xuat(so_phieuxuat),
foreign key (ma_vattu) references vat_tu(ma_vattu)
);
create table phieu_nhap(
so_phieunhap int primary key,
ngay_nhap date
);
create table don_dathang(
so_dathang int primary key,
ngay_dathang date
);
create table chitiet_phieunhap(
dongia_nhap varchar(20),
soluong_nhap int,
so_phieunhap int,
ma_vattu varchar(20),
foreign key (so_phieunhap) references phieu_nhap(so_phieunhap),
foreign key (ma_vattu) references vat_tu(ma_vattu)
);
create table nha_cungcap(
ma_nhacungcap varchar(20) primary key,
ten_ncc varchar(50),
diachi varchar(50),
sdt varchar(10)
);
create table chitiet_dondathang(
so_dathang int,
ma_vattu varchar(20),
foreign key (so_dathang) references don_dathang(so_dathangchitiet_dondathang),
foreign key (ma_vattu) references vat_tu(ma_vattu)
);
create table cung_cap(
so_dathang int,
foreign key (so_dathang) references don_dathang(so_dathang)
);
