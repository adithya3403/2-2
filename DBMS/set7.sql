-- set 7

-- 1. Write a query to invoke trigger after updating a row in students table such that the newly updated sid in students table should even reflect in enrolled table as shown in output.

delimiter ;

delimiter $$

set FOREIGN_KEY_CHECKS=0; $$

Create Trigger
    after_update_students AFTER UPDATE
    ON Students FOR EACH ROW BEGIN
UPDATE Enrolled SET sid = new.sid
where sid = old.sid;

END $$ 

delimiter ;

update Students set sid=66666 where sid=55556;

select * from students;

-- 2. Display Order Details for given an orderID Order Detials: productname and unitprice for given orderID

select
    a.ProductName,
    b.UnitPrice
from Products a, OrderDetails b
where
    b.ProductID = a.ProductID
    and b.OrderID = 9003;

/*
 output:
 +-------------+------------+
 | ProductName | UnitPrice  |
 +-------------+------------+
 | pendrive    | 30000.0000 |
 +-------------+------------+
 */