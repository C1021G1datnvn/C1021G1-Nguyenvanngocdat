create database FURAMASERVICE;
use FURAMASERVICE;
create table VI_TRI(
ma_vitri int primary key not null auto_increment,
ten_vitri varchar(45)
);
create table TRINH_DO(
ma_trinhdo int not null primary key auto_increment,
ten_trinhdo varchar(45)
);
create table BO_PHAN(
ma_bophan int not null primary key auto_increment,
ten_bophan varchar(45)
);
create table NHAN_VIEN(
ma_nhanvien int not null primary key auto_increment,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
luong double,
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vitri int,
ma_trinhdo int, 
ma_bophan int,
foreign key (ma_vitri) references VI_TRI(ma_vitri),
foreign key (ma_trinhdo) references TRINH_DO(ma_trinhdo),
foreign key (ma_bophan) references BO_PHAN(ma_bophan)
);
create table LOAI_KHACH(
ma_loaikhach int not null primary key auto_increment,
ten_loaikhach varchar(45)
);
create table KHACH_HANG(
ma_khachhang int not null primary key auto_increment,
ma_loaikhach int,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (ma_loaikhach) references LOAI_KHACH(ma_loaikhach)
);
create table LOAI_DICH_VU(
ma_loaidichvu int not null primary key auto_increment,
ten_loaidichvu varchar(45)
);
create table KIEU_THUE(
ma_kieuthue int not null primary key auto_increment,
ten_kieuthue varchar(45)
);
create table DICH_VU(
ma_dichvu int not null primary key auto_increment,
ten_dichvu varchar(45),
dien_tich int check(dien_tich > 30),
chi_phithue double,
so_nguoi_dathue int,
tieuchuan_phong varchar(45),
mota_tiennghi varchar(45),
dientich_hoboi double,
so_tang int,
ma_loaidichvu int,
ma_kieuthue int,
foreign key (ma_loaidichvu) references LOAI_DICH_VU(ma_loaidichvu),
foreign key (ma_kieuthue) references KIEU_THUE(ma_kieuthue)
);
create table HOP_DONG(
ma_hopdong int not null primary key auto_increment,
ngay_lam_hopdong datetime,
ngay_ketthuc datetime,
tien_datcoc double,
ma_nhanvien int,
ma_khachhang int,
ma_dichvu int,
foreign key (ma_nhanvien) references NHAN_VIEN(ma_nhanvien),
foreign key (ma_khachhang) references KHACH_HANG(ma_khachhang),
foreign key (ma_dichvu) references DICH_VU(ma_dichvu)
);
create table DICVU_DIKEM(
ma_dichvu_dikem int not null primary key auto_increment,
ten_dichvu_dikem varchar(45),
gia double,
don_vi varchar(45),
trang_thai varchar(45)
);
create table HOPDONG_CHITIET(
ma_hopdong_chitiet int not null primary key auto_increment,
ma_hopdong int,
ma_dichvu_dikem int,
so_luong int,
foreign key (ma_hopdong) references HOP_DONG(ma_hopdong),
foreign key (ma_dichvu_dikem) references DICVU_DIKEM(ma_dichvu_dikem)
);















