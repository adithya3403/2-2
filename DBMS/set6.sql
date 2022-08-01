-- set 6

-- 1. Write a query to invoke trigger before updating a row in students table such that the newly updated gpa in students table if exceeds 10 then make it 10.

delimiter ;

delimiter $$

CREATE TRIGGER before_update_students BEFORE UPDATE 
ON Students FOR EACH ROW 
BEGIN 
	IF new.gpa > 10 THEN set new.gpa=10;
END IF; 

END $$ update Students set gpa=20 where sid=55555;

select * from students;

-- 2. Display the total amount for each order

SELECT
    OrderDetails.OrderID,
    Sum(ROUND(OrderDetails.UnitPrice * Quantity)) AS Subtotal
FROM OrderDetails
GROUP BY OrderDetails.OrderID;

/*
 output:
 +---------+----------+
 | OrderID | Subtotal |
 +---------+----------+
 |    9001 |   200000 |
 |    9002 |   125000 |
 |    9003 |   300000 |
 |    9004 |   115000 |
 |    9005 |   250000 |
 +---------+----------+
 */