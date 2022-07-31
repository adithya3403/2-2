-- set 2

-- 1. Create a procedure to accept a customerID and display the customer order history(productname and how much quantity ordered for that particular product)
-- Ex : productname, Total_quantity he/she ordered.

DELIMITER $$ 

CREATE PROCEDURE CustOrderHist(IN AtCustomerID VARCHAR(5)) 
BEGIN 
	SELECT
		ProductName, SUM(Quantity) as TOTAL
	FROM Products
		INNER JOIN OrderDetails USING(ProductID)
		INNER JOIN Orders USING (OrderID)
		INNER JOIN Customers USING (CustomerID)
	WHERE Customers.CustomerID = AtCustomerID
	GROUP BY ProductName;
END $$ 

DELIMITER ; 

call CustOrderHist(1003);

/*
 output:
 +-------------+-------+
 | ProductName | TOTAL |
 +-------------+-------+
 | pendrive    |    10 |
 +-------------+-------+
 */

-- 2. List all products grouped by category

select * from Products group by ProductID;

/*
 output:
 +-----------+-------------+------------+------------+-----------------+------------+--------------+--------------+--------------+--------------+
 | ProductID | ProductName | SupplierID | CategoryID | QuantityPerUnit | UnitPrice  | UnitsInStock | UnitsOnOrder | ReorderLevel | Discontinued |
 +-----------+-------------+------------+------------+-----------------+------------+--------------+--------------+--------------+--------------+
 |      6001 | computer    |       2001 |       7001 | 25 computers    | 25000.0000 |           20 |           10 |            5 | NULL         |
 |      6002 | laptop      |       2002 |       7002 | 20 laptops      | 45000.0000 |           10 |            5 |            3 | NULL         |
 |      6003 | pendrive    |       2003 |       7003 | 35 pendrives    |  1000.0000 |           30 |           10 |            5 | NULL         |
 |      6004 | memory card |       2004 |       7004 | 45 memory cards |   500.0000 |           50 |           20 |           10 | NULL         |
 |      6005 | headphones  |       2005 |       7005 | 20 headphones   |  1000.0000 |           30 |           15 |           10 | NULL         |
 +-----------+-------------+------------+------------+-----------------+------------+--------------+--------------+--------------+--------------+
 */