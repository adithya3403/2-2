-- set 1

-- 1. Create a Procedure to display order details of given customerID like ordered, orderDate, RequiredDate, ShippedDate.

DELIMITER ;

DELIMITER $$ 

CREATE PROCEDURE CustOrders(IN AtCustomerID VARCHAR(5)) 
BEGIN 
	SELECT
		OrderID,
		OrderDate,
		RequiredDate,
		ShippedDate
	FROM Orders
	WHERE CustomerID = AtCustomerID;
END $$ 

DELIMITER ; 

call CustOrders(1003);

/*
 output:
 +---------+---------------------+---------------------+---------------------+
 | OrderID | OrderDate           | RequiredDate        | ShippedDate         |
 +---------+---------------------+---------------------+---------------------+
 |    9003 | 1998-11-06 00:00:00 | 1998-12-04 00:00:00 | 1998-11-08 00:00:00 |
 +---------+---------------------+---------------------+---------------------+
 */

-- 2. Get the highest sold product from given supplierID

select max(UnitsInStock) from Products;

/*
 output:
 +-------------------+
 | max(UnitsInStock) |
 +-------------------+
 |                50 |
 +-------------------+
 */