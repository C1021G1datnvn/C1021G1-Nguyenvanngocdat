use furamaservice;
-- câu 2
select * from nhan_vien 
where (ho_ten like "h%" 
or ho_ten like "k%" 
or ho_ten like "t%" )
and char_length(ho_ten)<15;
-- câu 3
select * from khach_hang
where (year(current_timestamp) - year(ngay_sinh) ) between 18 and 50
and (dia_chi like "%Đà Nẵng" or dia_chi like "%Quảng Trị");
-- câu 4
select khach_hang.ma_khachhang, khach_hang.ho_ten, count(ma_hopdong)
from hop_dong
inner join khach_hang on hop_dong.ma_khachhang = khach_hang.ma_khachhang
inner join loai_khach on khach_hang.ma_loaikhach = loai_khach.ma_loaikhach
where loai_khach.ma_loaikhach = "1"
group by ma_khachhang 
order by count(ma_hopdong) asc;
-- câu 5
select khach_hang.ma_khachhang, khach_hang.ho_ten, loai_khach.ten_loaikhach, hop_dong.ma_hopdong, 
dich_vu.ten_dichvu, hop_dong.ngay_lam_hopdong, hop_dong.ngay_ketthuc,
if(hopdong_chitiet.so_luong is null , dich_vu.chi_phithue, sum(dich_vu.chi_phithue + hopdong_chitiet.so_luong * dicvu_dikem.gia)) as "Tong tien"
from khach_hang 
left join loai_khach on khach_hang.ma_loaikhach = loai_khach.ma_loaikhach
left join hop_dong on khach_hang.ma_khachhang = hop_dong.ma_khachhang
left join dich_vu on hop_dong.ma_dichvu = dich_vu.ma_dichvu
left join hopdong_chitiet on hop_dong.ma_hopdong = hopdong_chitiet.ma_hopdong
left join dicvu_dikem on hopdong_chitiet.ma_dichvu_dikem = dicvu_dikem.ma_dichvu_dikem
group by hop_dong.ma_hopdong
order by khach_hang.ma_khachhang, hop_dong.ma_hopdong  asc; 
-- câu 6
select dich_vu.ma_dichvu, dich_vu.ten_dichvu, dich_vu.dien_tich, dich_vu.chi_phithue, loai_dich_vu.ten_loaidichvu 
from dich_vu 
inner join loai_dich_vu 
on dich_vu.ma_loaidichvu = loai_dich_vu.ma_loaidichvu 
inner join hop_dong 
on dich_vu.ma_dichvu = hop_dong.ma_dichvu
where hop_dong.ngay_lam_hopdong not between "2021-01-01" and "2021-03-31"
group by ten_dichvu;
-- câu 7
select  dich_vu.ma_dichvu, ten_dichvu, dich_vu.dien_tich, dich_vu.so_nguoi_dathue, dich_vu.chi_phithue, loai_dich_vu.ten_loaidichvu
from dich_vu
inner join loai_dich_vu
on dich_vu.ma_loaidichvu = loai_dich_vu.ma_loaidichvu
inner join hop_dong
on dich_vu.ma_dichvu = hop_dong.ma_dichvu
where year(hop_dong.ngay_lam_hopdong) = "2020";
-- caau 8
-- c1
select distinct khach_hang.ho_ten from khach_hang;
-- c2
select khach_hang.ho_ten from khach_hang
union
select khach_hang.ho_ten from khach_hang;
-- c3
select khach_hang.ho_ten from khach_hang 
group by khach_hang.ho_ten;
-- câu 9
select month(hop_dong.ngay_lam_hopdong) as "thang", count(ma_khachhang) as "so luong"
from hop_dong
inner join dich_vu
on hop_dong.ma_dichvu = dich_vu.ma_dichvu
where (year(hop_dong.ngay_lam_hopdong) = 2021)
group by month(ngay_lam_hopdong) 
order by ngay_lam_hopdong asc;
-- câu 10
SELECT hop_dong.ma_hopdong,hop_dong.ngay_lam_hopdong,hop_dong.ngay_ketthuc,hop_dong.tien_datcoc,SUM(hopdong_chitiet.so_luong)
FROM hop_dong 
LEFT JOIN hopdong_chitiet ON hop_dong.ma_hopdong = hopdong_chitiet.ma_hopdong 
GROUP BY ma_hopdong;
-- câu 11
select  dicvu_dikem.ma_dichvu_dikem , dicvu_dikem.ten_dichvu_dikem from loai_khach
INNER JOIN khach_hang ON loai_khach.ma_loaikhach = khach_hang.ma_loaikhach
INNER JOIN hop_dong ON khach_hang.ma_khachhang = hop_dong.ma_khachhang
INNER JOIN hopdong_chitiet ON hop_dong.ma_hopdong = hopdong_chitiet.ma_hopdong
INNER JOIN dicvu_dikem ON hopdong_chitiet.ma_dichvu_dikem = dicvu_dikem.ma_dichvu_dikem
where loai_khach.ten_loaikhach = "Diamond" and (khach_hang.dia_chi like "%Vinh" or khach_hang.dia_chi like "%Quảng Ngãi");
-- câu 12
select hop_dong.ma_hopdong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.sdt, dich_vu.ten_dichvu, 
sum(hopdong_chitiet.so_luong) as "so_luong_dich_vu_di_kem", hop_dong.tien_datcoc
from nhan_vien 
left join hop_dong 
on nhan_vien.ma_nhanvien = hop_dong.ma_nhanvien
left join khach_hang
on khach_hang.ma_khachhang = hop_dong.ma_khachhang
left join hopdong_chitiet
on hopdong_chitiet.ma_hopdong = hop_dong.ma_hopdong
left join dich_vu 
on dich_vu.ma_dichvu = hop_dong.ma_dichvu
WHERE  dich_vu.ten_dichvu NOT IN
(SELECT dich_vu.ma_dichvu
FROM dich_vu 
JOIN hop_dong 
ON dich_vu.ma_dichvu = hop_dong.ma_dichvu
WHERE year(hop_dong.ngay_lam_hopdong) = 2021 AND month(hop_dong.ngay_lam_hopdong) in (1,2,3,4,5,6) )
AND (year(hop_dong.ngay_lam_hopdong) = 2020 AND month(hop_dong.ngay_lam_hopdong) in (10,11,12))
GROUP BY khach_hang.ho_ten;
-- câu 13
SELECT dicvu_dikem.ma_dichvu_dikem, dicvu_dikem.ten_dichvu_dikem,SUM(so_luong) AS "so_luong_dich_vu_di_kem"
FROM dicvu_dikem 
LEFT JOIN hopdong_chitiet 
ON dicvu_dikem.ma_dichvu_dikem = hopdong_chitiet.ma_dichvu_dikem
GROUP BY dicvu_dikem.ma_dichvu_dikem
HAVING SUM(so_luong) = (SELECT SUM(so_luong) 
FROM hopdong_chitiet 
JOIN dicvu_dikem
ON hopdong_chitiet.ma_dichvu_dikem = dicvu_dikem.ma_dichvu_dikem
GROUP BY dicvu_dikem.ma_dichvu_dikem
ORDER BY SUM(so_luong) DESC
LIMIT 1);
-- câu 14
select hop_dong.ma_hopdong, loai_dich_vu.ten_loaidichvu, dicvu_dikem.ten_dichvu_dikem, count(dicvu_dikem.ma_dichvu_dikem) as "so_lan"
from hop_dong 
inner join hopdong_chitiet 
on hop_dong.ma_hopdong = hopdong_chitiet.ma_hopdong	
inner join dicvu_dikem
on hopdong_chitiet.ma_dichvu_dikem = dicvu_dikem.ma_dichvu_dikem
inner join dich_vu 
on hop_dong.ma_dichvu = dich_vu.ma_dichvu
inner join loai_dich_vu 
on dich_vu.ma_loaidichvu = loai_dich_vu.ma_loaidichvu
group by dicvu_dikem.ten_dichvu_dikem
having so_lan = 1
order by ma_hopdong;
-- câu 15
select nhan_vien.ma_nhanvien, nhan_vien.ho_ten, trinh_do.ten_trinhdo, bo_phan.ten_bophan, nhan_vien.sdt, nhan_vien.dia_chi
from nhan_vien 
inner join hop_dong
on nhan_vien.ma_nhanvien = hop_dong.ma_nhanvien
inner join trinh_do
on nhan_vien.ma_trinhdo = trinh_do.ma_trinhdo
inner join bo_phan
on nhan_vien.ma_bophan = bo_phan.ma_bophan
group by nhan_vien.ma_nhanvien
having count(hop_dong.ma_hopdong) <= 3;
-- câu 16
-- SET SQL_SAFE_UPDATES = 0;
-- SET SQL_SAFE_UPDATES = 1;
SET FOREIGN_KEY_CHECKS=0; -- vô hiệu hoá khoá ngoại
delete 
from nhan_vien
where ma_nhanvien not in (
select ma_nhanvien
from hop_dong
where ngay_lam_hopdong between '2019-01-01' and '2021-12-31');
SET FOREIGN_KEY_CHECKS=1; -- bật lại 
select * from nhan_vien;
-- câu 17
create temporary table bang_tam
select khach_hang.ma_khachhang from khach_hang
inner join hop_dong
on khach_hang.ma_khachhang = hop_dong.ma_khachhang
inner join dich_vu 
on hop_dong.ma_dichvu = dich_vu.ma_dichvu
inner join hopdong_chitiet
on hopdong_chitiet.ma_hopdong = hop_dong.ma_hopdong
inner join dicvu_dikem
on dicvu_dikem.ma_dichvu_dikem = hopdong_chitiet.ma_dichvu_dikem
inner join loai_khach
on khach_hang.ma_loaikhach = loai_khach.ma_loaikhach
where loai_khach.ten_loaikhach = "Platinium"
group by hop_dong.ma_hopdong
having sum(dich_vu.chi_phithue + hopdong_chitiet.so_luong * dicvu_dikem.gia) > 10000000;
select * from bang_tam;
update loai_khach
set ten_loaikhach = "Diamond" 
where (loai_khach.ten_loaikhach = "Platinium");
-- câu 18
SET FOREIGN_KEY_CHECKS=0;
create temporary table bang_tam1
select khach_hang.ma_khachhang, hop_dong.ngay_lam_hopdong from khach_hang
inner join hop_dong
on  khach_hang.ma_khachhang = hop_dong.ma_khachhang
where year(hop_dong.ngay_lam_hopdong) < 2021;
delete from khach_hang
where khach_hang.ma_khachhang 
in (select bang_tam1.ma_khachhang from bang_tam1);
SET FOREIGN_KEY_CHECKS=1;

-- câu 19
create temporary table bang_tam2
select dicvu_dikem.ma_dichvu_dikem from dicvu_dikem
inner join hopdong_chitiet
on hopdong_chitiet.ma_dichvu_dikem = dicvu_dikem.ma_dichvu_dikem
inner join hop_dong
on hop_dong.ma_hopdong = hopdong_chitiet.ma_hopdong
where hopdong_chitiet.so_luong > 10 and year(hop_dong.ngay_lam_hopdong) = 2020;
select * from bang_tam2;
update dicvu_dikem
set dicvu_dikem.gia = dicvu_dikem.gia*2
where dicvu_dikem.ma_dichvu_dikem in (select bang_tam2.ma_dichvu_dikem from bang_tam2);
drop table bang_tam2;
-- cau 20
select nhan_vien.ma_nhanvien, nhan_vien.ho_ten, nhan_vien.email, nhan_vien.sdt, nhan_vien.ngay_sinh, nhan_vien.dia_chi from nhan_vien
union 
select khach_hang.ma_khachhang, khach_hang.ho_ten, khach_hang.email, khach_hang.sdt, khach_hang.ngay_sinh, khach_hang.dia_chi from khach_hang;


