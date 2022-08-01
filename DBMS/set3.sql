-- set 3

-- 1. Create a procedure to display Ten Most Expensive Products Columns should be displayed Productname & Unit price

DELIMITER ; 

DELIMITER $$ 

CREATE PROCEDURE TenMostExpensiveProducts() 
BEGIN 
	SELECT
        Products.ProductName AS TenMostExpensiveProducts,
        Products.UnitPrice
	FROM Products
	ORDER BY Products.UnitPrice
    DESC LIMIT 10;
END $$ 

DELIMITER ;

CALL TenMostExpensiveProducts ();

/*
 output:
 +--------------------------+------------+
 | TenMostExpensiveProducts | UnitPrice  |
 +--------------------------+------------+
 | laptop                   | 45000.0000 |
 | computer                 | 25000.0000 |
 | pendrive                 |  1000.0000 |
 | headphones               |  1000.0000 |
 | memory card              |   500.0000 |
 +--------------------------+------------+
 */

-- 2. List the products, whose products unit price is greater then all the products of average.

SELECT
    ProductID,
    ProductName,
    UnitPrice
FROM Products
WHERE UnitPrice > (
        SELECT AVG(UnitPrice)
        FROM Products
    );

/*
 output:
+-----------+-------------+------------+
| productId | productName | unitprice  |
+-----------+-------------+------------+
|      6001 | computer    | 25000.0000 |
|      6002 | laptop      | 45000.0000 |
+-----------+-------------+------------+
 */