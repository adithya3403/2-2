-- set 7

-- 1. Write a query to invoke trigger after updating a row in students table such that the newly updated sid in students table should even reflect in enrolled table as shown in output.

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