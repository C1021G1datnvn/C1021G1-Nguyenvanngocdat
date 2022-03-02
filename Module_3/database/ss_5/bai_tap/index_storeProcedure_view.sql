create database demo;
use demo;
create table products(
id int not null primary key auto_increment,
productCode varchar(50),
productName varchar(50),
productPrice varchar(50),
productAmount varchar(50),
productDescription varchar(50),
productStatus varchar(50)
);
insert into products
value(1,1,"Honda",1000,1,"xe hơi","Hết hàng");

insert into products
value(2,2,"BMW",2000,1,"xe hơi","Còn hàng");

insert into products
value(3,3,"Audi",2500,3,"xe hơi","Còn hàng");
-- tạo unique index.
create unique index unique_index 
on products(productCode); 
-- tạo composite
create index composite_index 
on products(productName, productPrice);
-- sữ dụng câu lệnh explane
explain select * from products;
-- tạo view
create view product_view as
select productCode, productName, productPrice, productStatus 
from products;
-- sửa đổi view
update product_view
set productName = "Mercedes"
where productCode="1";
-- xoá view
drop view product_view;
-- tạo store procedure
delimiter // 
create procedure allproducts()
begin 
select * from products;
end //
delimiter ;
call allproducts();
-- thêm 1 sản phẩm mới bằng store procedure
delimiter //
create procedure update_product (pid int,`pname` varchar(40))
begin
update products
set productName = `pname`
where id = pid;
end;
// delimiter ;
call update_product( 2 , "BMW" );
 -- xoá bằng store procedure
 
delimiter //
create procedure
delete_product_by_id ( id int )
begin
delete from products
where products.id = id;
end;
// delimiter ;
call delete_product_by_id( 2 );









