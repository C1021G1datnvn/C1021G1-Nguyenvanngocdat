use quanli_banhang;
insert into Customer(ciD, cName, cAge) values (1, "Minh Quan", 10), (2, "Ngoc Oanh", 20), (3, "Hong Ha", 50);

insert into `order`(oID, cID, oDate, oTotalPrice) values (1, 1, "2006-03-21", null), (2, 2, "2006-03-23", null), (3, 1, "2006-03-13", null);

insert into product(pID, pName, pPirce) values (1, "May giat", 3), (2, "Tu lanh", 5), (3, "Dieu hoa", 7), (4, "Quat", 1), (5, "Bep dien", 2);

insert into OrderDetail(oID, pID, odQTY) values (1, 1, 3), (1, 3, 7), (1, 4, 2), (2, 1, 1), (3, 1, 8), (2, 5, 4), (2, 3, 3);