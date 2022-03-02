use quanli_banhang;
select oID, oDate, oTotalPrice from `order`;

select customer.cName, product.pName from customer 
inner join `order` on customer.cID = `order`.cID
inner join orderdetail on `order`.oID = orderdetail.oID 
inner join product on orderdetail.pID = product.pID;

select customer.cName from customer
left join `order` on customer.cID = `order`.cID
where oID is null;

SELECT order_detail.oID,orders.oDate,order_detail.odQTY * product.pPirce FROM
customer INNER JOIN orders on customer.cID = orders.cID 
INNER JOIN order_detail on order_detail.oID = orders.oID 
INNER JOIN product on product.pID = order_detail.pID;

SELECT orderdetail.oid,`order`.odate,SUM(orderdetail.odQTY * product.pPrice ) AS “totalprice”
FROM customer INNER JOIN `order` on customer.cID = `order`.cID
INNER JOIN orderdetail on orderdetail.oid = `order`.oid
INNER JOIN product on product.pid = orderdetail.pid
GROUP BY orderdetail.oid;