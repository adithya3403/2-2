-- set 10

-- 1. create a user and grant the user create, insert, delete priviileges

create user 'sample'@'localhost' identified by '';

grant create, insert, delete on *.* to 'sample'@'localhost';

show grants for 'sample'@'localhost';

/*
 output:
 +-------------------------------------------------------------+
 | Grants for sample@localhost                                 |
 +-------------------------------------------------------------+
 | GRANT INSERT, DELETE, CREATE ON *.* TO `sample`@`localhost` |
 +-------------------------------------------------------------+
 */

-- 2. create a view to display the products by category. Display the productName, QuantityPerUnit.

create view products_by_category as 
	select productName, quantityPerUnit from 
products; 

select * from products_by_category;

/*
 output:
 +-------------+-----------------+
 | productName | quantityPerUnit |
 +-------------+-----------------+
 | computer    | 25 computers    |
 | laptop      | 20 laptops      |
 | pendrive    | 35 pendrives    |
 | memory card | 45 memory cards |
 | headphones  | 20 headphones   |
 +-------------+-----------------+
 */