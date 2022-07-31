-- set 6

-- 1. Write a query to invoke trigger before updating a row in students table such that the newly updated gpa in students table if exceeds 10 then make it 10.

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