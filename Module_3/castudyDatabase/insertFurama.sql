create database insertFurama;
use insertFurama;
insert into VI_TRI (ma_vitri, ten_vitri) values ("1", "Quản Lí"), ("2", "Nhân Viên");
insert into TRINH_DO(ma_trinhdo, ten_trinhdo) values ("1","Trung Cấp"), ("2","Cao Đẳng"), ("3","Đại Học"), ("4","Sau Đại Học");
insert into BO_PHAN(ma_bophan, ten_bophan) values ("1","Sale-Marketting"), ("2","Hành Chính"), ("3","Dịch Vụ"), ("4","Quản Lí");
insert into NHAN_VIEN(ho_ten, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi, ma_vitri, ma_trinhdo, ma_bophan) 
values ("Nguyễn Văn An", "1970-11-07","456231786", "10000000", "0123456789", "annguyen@gmail.com", "295 Nguyễn Tất Thành, Đà Nẵng", 1, 3, 1),
("Lê Văn Bình", "1997-04-09", "654231234", "7000000", "0984534758", "binhlv@gmail.com", "22 Yên Bái, Đà Nẵng", "1", "2", "2"),
("Hồ Thị Yến", "1995-12-12", "999231723", "14000000", "0456764542", "thiyen@gmail.com", "K234/11 Điện Biên Phủ, Gia Lai", "1", "3", "2"),
("Võ Công Toản", "1980-04-04", "123231365", "17000000", "0379853432", "toan0404@gmail.com", "77 Hoàng Diệu, Quảng Trị", "1", "4", "4"),
("Nguyễn Bỉnh Phát", "1999-12-09", "454363232", "6000000", "0902433454", "phatphat@gmail.com", "43 Yên Bái, Đà Nẵng", "2", "1", "1"),
("Khúc Nguyễn An Nghi", "2000-11-08", "964542311", "7000000", "0978650000", "annghi20@gmail.com", "294 Nguyễn Tất Thành, Đà Nẵng", "2", "2", "3"),
("Nguyễn Hữu Hà", "1993-01-01", "534323231", "8000000", "0941234553", "nhh0101@gmail.com", "4 Nguyễn Chí Thanh, Huế", "2", "3", "2"),
("Nguyễn Hà Đông", "1989-09-03", "234414123", "9000000", "0642123111", "donghanguyen@gmail.com", "11 Hùng Vương, Hà Nội", "2", "4", "4"),
("Tòng Hoang", "1982-09-03", "256781231", "6000000", "0245144444", "hoangtong@gmail.com", "213 Hàm Nghi, Đà Nẵng", "2", "4", "4"),
("Nguyễn Công Đạo", "1994-01-08", "755434343", "8000000", "0988767111", "nguỹenongdao12@gmail.com", "6 Hoà Khánh, Đồng Nai", "2", "3", "2");
insert into LOAI_KHACH(ma_loaikhach, ten_loaikhach) values ("1", "Diamond"), ("2", "Platinium"), ("3", "Gold"), ("4", "Silver"), ("5", "Member");
insert into KHACH_HANG(ma_loaikhach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi) 
values ("5","Nguyễn Thị Hào", "1970-11-07", b'0', "643431213", "0945459999", "thihao07@gmail.com", "23 Nguyễn Hoàng, Đà Nẵng"),
 ("3","Phạm Xuân Diệu", "1992-08-08", b'1', "865342123", "0954678909", "xuandieu92@gmail.com", "K77/22 Thái Phiên, Quảng Trị"),
 ("1","Trương Đình Nghệ", "1990-02-27", b'1', "488645199", "0373213122", "nghenhan2702@gmail.com", "K323/12 Ông Ích Khiêm, Vinh"),
 ("1","Dương Văn Quang", "1981-07-08", b'1', "543421111", "0490039241", "duongquan@gmail.com", "K452/12 Lê Lợi, Đà Nẵng"),
 ("4","Hoàng Trần Nhi Nhi", "1995-12-09", b'0', "795453345", "0312345678", "nhinhi123@gmail.com", "242 Lý Thái Tổ, Gia Lai"),
 ("4","Tôn Nữ Mộc Châu", "2005-12-06", b'0', "732434215", "0988888844", "tonnuchau@gmail.com", "37 Yên Thế, Đà Nẵng"),
 ("1","Nguyễn Mỹ Kim", "1984-04-08", b'0', "856453123", "0912345698", "kimcuong84@gmail.com", "K123/45 Lê Lợi, Hồ Chí Minh"),
 ("3","Nguyễn Thị Hào", "1999-04-08", b'0', "965656433", "0763212345", "haohao99@gmail.com", "55 Nguyễn Văn Linh, Kom Tum"),
 ("1","Trần Đại Danh", "1994-07-01", b'1', "432341235", "0643343433", "danhhai99@gmail.com", "24 Lý Thường Kiệt, Quảng Ngãi"),
 ("2","Nguyễn Tâm Đắc", "1989-07-01", b'1', "344343432", "0987654321", "dactam@gmail.com", "22 Ngô Quyền, Đà Nẵng");
insert into KIEU_THUE(ma_kieuthue, ten_kieuthue) values ("1", "year"), ("2", "month"), ("3", "day"), ("4", "hour");
insert into LOAI_DICH_VU(ma_loaidichvu, ten_loaidichvu) values ("1", "Villa"), ("2", "House"), ("3", "Room");
insert into DICH_VU(ten_dichvu, dien_tich, chi_phithue, so_nguoi_dathue, tieuchuan_phong, mota_tiennghi, dientich_hoboi, so_tang, ma_loaidichvu, ma_kieuthue)
values
("Villa Beach Front", 25000, 10000000, 10, "vip", "Có hồ bơi", 500, 4, 1, 3),
("House Princess 01", 14000, 5000000, 7, "vip", "Có thêm Bếp Nướng",null, 3, 2, 2),
("Room Twin 01", 5000, 1000000, 2, "normal", "Có TV",null, null, 3, 4),
("Villa Beach Front", 22000, 9000000, 8, "normal", "Có hồ bơi", 300, 3, 1, 3),
("House Princess 02", 10000, 4000000, 5, "normal", "Có thêm Bếp Nướng", null, 2, 2, 3),
("Room Twin 02", 3000, 900000, 2, "normal", "Có TV",null, null, 3, 4);
insert into DICVU_DIKEM(ten_dichvu_dikem, gia, don_vi, trang_thai) values
("Karaoke", "10000", "giờ", "tiện nghi, hiện đại"),
("Thuê xe máy", "10000", "Chiếc", "hỏng 1 xe"),
("Thuê xe đẹp", "20000", "Chiếc", "Tốt"),
("Buffer buổi sáng", "15000", "Suất", "đầy đủ đồ ăn, tráng miệng"),
("Buffer buổi trưa", "9000", "Suất", "đầy đủ đồ ăn, tráng miệng"),
("Buffer buổi tối", "16000", "Suất", "đầy đủ đồ ăn, tráng miệng");
insert into HOP_DONG(ngay_lam_hopdong, ngay_ketthuc, tien_datcoc, ma_nhanvien, ma_khachhang, ma_dichvu)
values 
("2021-12-08", "2021-12-08", 0, 3, 1, 27),
("2021-07-14", "2021-07-21", 200000, 7, 3,25),
("2021-03-15", "2021-03-17", 50000, 3,4, 26),
("2021-01-14", "2021-01-18", 100000, 7, 5, 29),
("2021-07-14", "2021-07-15", 0, 7, 2, 30),
("2021-06-01", "2021-06-03", 0, 7, 7, 30),
("2021-09-02", "2021-09-05", 100000, 7, 4, 28),
("2021-06-17", "2021-06-18", 150000, 3, 4, 25),
("2020-11-19", "2020-11-19", 0, 3, 4, 27),
("2021-04-12", "2021-04-14", 0, 10, 3, 29),
("2021-04-25", "2021-04-25", 0, 2, 2, 25),
("2021-05-25", "2021-05-27", 0, 7,10, 25);
insert into HOPDONG_CHITIET(ma_hopdong, ma_dichvu_dikem, so_luong)
values
(26, 4, 5),
(26, 5, 8),
(26, 6, 15),
(27, 1, 1),
(27, 2, 11),
(25, 3, 1),
(25, 2, 2),
(36, 2, 2);








