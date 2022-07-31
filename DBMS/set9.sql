-- set 9

-- 1. Write a query to invoke trigger after deleting a row in students table such that the deleted sid in students table should even be deleted in enrolled table.

DELIMITER ;

DELIMITER $$

SET FOREIGN_KEY_CHECKS = 0;

Create Trigger after_delete_students
AFTER DELETE ON Students
FOR EACH ROW 
BEGIN 
	DELETE FROM Enrolled where sid=old.sid;
END $$ 

DELETE FROM Students where sid =66666; 

select * from Students;

-- 2. write a query to perform left outer join operation of employee and department table

select
    employee.empId,
    employee.empName,
    department.deptName
from employee
    left outer join department on employee.deptId = department.deptId;

/*
 output:
 +-------+---------+----------+
 | empId | empName | deptName |
 +-------+---------+----------+
 |     1 | Harry   | Mech     |
 |     2 | Tom     | IT       |
 |     3 | Joy     | NULL     |
 |     4 | Roy     | NULL     |
 +-------+---------+----------+
 */