-- show databases;

-- create database today;

-- use today;

-- show tables;

-- create table
--     student(
--         student_id int,
--         name varchar(20),
--         address varchar(20),
--         marks int
--     );

-- desc student;

-- insert into student
-- values (1, 'billie', 'ny', 220), (2, 'eilish', 'london', 190), (3, 'ariana', 'miami', 180);

-- select * from student;

-- show triggers;

-- drop trigger if EXISTS add_marks;

-- create or replace trigger add_marks before insert on student 
-- for each row set new.marks =new.marks+100; 

/*
Create a Procedure to display order details of given customerID like ordered, orderDate , RequiredDate, ShippedDat
Create a procedure to accept a customerID and display the customer order history(productname and how much quantity ordered for that particular product)
Create a procedure to display Ten Most Expensive Products Columns should be displayed Productname & Unit price
*/

