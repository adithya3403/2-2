-- set 5

-- 1. Write a query to invoke trigger after inserting a row in students table such that the newly inserted sid in students table should even reflect in enrolled table as shown in output.

/* tables creation and insertion:
create table Students (
sid CHAR(20),
name char (30),
login char(20),
age int,
gpa REAL,
UNIQUE (name, age),
UNIQUE(login),
CONSTRAINT StudentsKey PRIMARY KEY (sid)
);
create table Enrolled (
sid CHAR(20),
cid CHAR(20),
grade CHAR(2),
PRIMARY KEY (sid, cid),
FOREIGN KEY (sid) REFERENCES Students(sid)
);
INSERT INTO Students (sid, name, login, age, gpa)
VALUES (53666, 'Jones', 'jones@cs', 18, 3.4),
(53688, 'Smith', 'Smith@ee', 18, 3.2),
(53667, 'Raj', 'Raj@cs', 20, 4.4),
(53650, 'Smith', 'smith@math', 19, 3.8);

select * from students;
+-------+-------+------------+------+------+
| sid   | name  | login      | age  | gpa  |
+-------+-------+------------+------+------+
| 53650 | Smith | smith@math |   19 |  3.8 |
| 53666 | Jones | jones@cs   |   18 |  3.4 |
| 53667 | Raj   | Raj@cs     |   20 |  4.4 |
| 53688 | Smith | Smith@ee   |   18 |  3.2 |
+-------+-------+------------+------+------+

INSERT INTO Enrolled(sid, cid, grade)
VALUES (53666, 'History105', 'B'), (53650, 'Topology112', 'A'), (53688, 'Reggae203', 'B'), (53688, 'Carnatic101', 'C');

select * from Enrolled;
+-------+-------------+-------+
| sid   | cid         | grade |
+-------+-------------+-------+
| 53650 | Topology112 | A     |
| 53666 | History105  | B     |
| 53688 | Carnatic101 | C     |
| 53688 | Reggae203   | B     |
+-------+-------------+-------+
 */

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