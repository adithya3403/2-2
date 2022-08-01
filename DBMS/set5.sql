-- set 5

-- 1. Write a query to invoke trigger after inserting a row in students table such that the newly inserted sid in students table should even reflect in enrolled table as shown in output.

delimiter ;

delimiter $$

Create Trigger after_insert_details AFTER INSERT ON 
Students FOR EACH ROW 
BEGIN 
	INSERT INTO Enrolled VALUES (new.sid, 'History', 'A');
END $$ 

delimiter ;

insert into Students values(55556, 'xq1', 'xq1@we',15,3.5);

select * from students;

-- 2. List the products which were sold in year 1997 Display categoryName and productname


SELECT
    Categories.CategoryName,
    Products.ProductName,
    Sum(ROUND(OrderDetails.UnitPrice * Quantity)) AS ProductSales
FROM Categories
    JOIN Products On Categories.CategoryID = Products.CategoryID
    JOIN OrderDetails on Products.ProductID = OrderDetails.ProductID
    JOIN Orders on Orders.OrderID = OrderDetails.OrderID
WHERE
    Orders.ShippedDate BETWEEN '1997-01-01' And '1997-12-31'
GROUP BY
    Categories.CategoryName,
    Products.ProductName;

/*
output:
Empty set
*/