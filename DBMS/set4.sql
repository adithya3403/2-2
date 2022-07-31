-- set 4

-- 1. Create a view to display the products by category. Display productname, quantityPerUnit,unitsInStock,Discontinued

CREATE VIEW product_by_category AS 
	SELECT
		products.ProductID,
		products.ProductName,
		products.QuantityPerUnit,
		products.UnitsInStock
	FROM products
		INNER JOIN categories ON products.CategoryID = categories.
CategoryID; 

select * from product_by_category;

/*
 output:
 +-----------+-------------+-----------------+--------------+
 | ProductID | ProductName | QuantityPerUnit | UnitsInStock |
 +-----------+-------------+-----------------+--------------+
 |      6001 | computer    | 25 computers    |           20 |
 |      6002 | laptop      | 20 laptops      |           10 |
 |      6003 | pendrive    | 35 pendrives    |           30 |
 |      6004 | memory card | 45 memory cards |           50 |
 |      6005 | headphones  | 20 headphones   |           30 |
 +-----------+-------------+-----------------+--------------+
 */

-- 2. List Details of order and customer of each order

SELECT *
FROM Customers
    JOIN Orders ON Customers.CustomerID = Orders.CustomerID;

/*
 output:
 +------------+-------------+------------------+----------------------+------------------------------+------------+--------+------------+---------+----------------+----------------+---------+------------+------------+---------------------+---------------------+---------------------+--------+-----------+-------------+
 | CustomerID | CompanyName | ContactName      | ContactTitle         | Address                      | City       | Region | PostalCode | Country | Phone          | Fax            | OrderID | CustomerID | EmployeeID | OrderDate           | RequiredDate        | ShippedDate         | ShipId | ShipName  | ShipAddress |
 +------------+-------------+------------------+----------------------+------------------------------+------------+--------+------------+---------+----------------+----------------+---------+------------+------------+---------------------+---------------------+---------------------+--------+-----------+-------------+
 | 1001       | tcs         | maria            | sales representative | Obere Str. 57                | Berlin     | NULL   | 12209      | Germany | 030-0074321    | 030-0076545    |    9001 | 1001       |       5001 | 1996-07-04 00:00:00 | 1996-08-01 00:00:00 | 1996-07-16 00:00:00 |      3 | Reims     | France      |
 | 1002       | wipro       | Ana              | Owner                | Avda. de la Constitucin 2222 | Mxico D.F. | NULL   | 05021      | Mexico  | (5) 555-4729   | (5) 555-3745   |    9002 | 1002       |       5002 | 1996-07-05 00:00:00 | 1996-08-16 00:00:00 | 1996-07-10 00:00:00 |      1 | Mnster    | Germany     |
 | 1003       | polaris     | Antonio          | Owner                | Mataderos 2312               | Mxico D.F. | NULL   | 05023      | Mexico  | (5) 555-3932   | (5) 565-3532   |    9003 | 1003       |       5003 | 1998-11-06 00:00:00 | 1998-12-04 00:00:00 | 1998-11-08 00:00:00 |      3 | SP        | Brazil      |
 | 1004       | virtuasa    | Thomas Hardy     | Sales Representative | 120 Hanover Sq.              | London     | NULL   | WA1 1DP    | UK      | (171) 555-7788 | (171) 555-6750 |    9004 | 1004       |       5004 | 2002-11-12 00:00:00 | 2002-11-26 00:00:00 | 2002-11-18 00:00:00 |      2 | Lisboa    | Portugal    |
 | 1005       | genpact     | Frdrique Citeaux | Marketing Manager    | 24, place Klber              | Strasbourg | NULL   | 67000      | France  | 88.60.15.31    | 88.60.15.32    |    9005 | 1005       |       5005 | 2008-11-25 00:00:00 | 2008-12-23 00:00:00 | 2008-11-28 00:00:00 |      4 | Marseille | France      |
 +------------+-------------+------------------+----------------------+------------------------------+------------+--------+------------+---------+----------------+----------------+---------+------------+------------+---------------------+---------------------+---------------------+--------+-----------+-------------+
 */