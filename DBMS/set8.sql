-- set 8

-- 1. Write a query to invoke trigger before deleting a row in students table such that the newly deleted row in students table should be added to new table called studentsdeleted.

delete from Enrolled where sid=55555;

CREATE TABLE
    studentsdeleted(
        sid CHAR(20),
        name CHAR (30),
        login CHAR(20),
        age INTEGER,
        gpa REAL,
        UNIQUE (name, age),
        UNIQUE(login),
        CONSTRAINT StudentsKey PRIMARY KEY (sid)
    );

delimiter ;

delimiter $$

CREATE TRIGGER before_delete_students BEFORE DELETE 
ON Students FOR EACH ROW 
BEGIN 
	INSERT INTO studentsdeleted
	values (
        old.sid,
        old.name,
        old.login,
        old.age,
        old.gpa
    );
END $$ 

delimiter ;

delete from Students where sid=55555;

select * from Students;

-- 2. write a query to perform equi join operation on employee and department tables

Select
    employee.empId,
    employee.empName,
    department.deptName
from employee
    inner join department on employee.deptId = department.deptId;

/*
 output: 
 +-------+---------+----------+
 | empId | empName | deptName |
 +-------+---------+----------+
 | 1     | Harry   | Mech     |
 | 2     | Tom     | IT       |
 +-------+---------+----------+
 */