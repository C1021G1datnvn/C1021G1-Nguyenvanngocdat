use classicmodels;

create view customer_views as 
select customerName, customerNumber, phone from customers;

select * from customer_views;

create or replace view customer_views as
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone

FROM customers

WHERE city = 'Nantes';

drop view customer_views; 