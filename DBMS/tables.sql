CREATE TABLE
    customers (
        CustomerID varchar(5) NOT NULL,
        CompanyName varchar(40) NOT NULL,
        ContactName varchar(30) Default NULL,
        ContactTitle varchar(30) Default NULL,
        Address varchar(60) Default NULL,
        City varchar(15) Default NULL,
        Region varchar(15) Default NULL,
        PostalCode varchar(10) Default NULL,
        Country varchar(15) Default NULL,
        Phone varchar(24) Default NULL,
        Fax varchar(24) Default NULL,
        PRIMARY KEY (CustomerID)
    );

INSERT INTO customers
VALUES (
        '1001',
        'tcs',
        'maria',
        'sales representative',
        'Obere Str. 57',
        'Berlin',
        NULL,
        '12209',
        'Germany',
        '030-0074321',
        '030-0076545'
    );

INSERT INTO customers
VALUES (
        '1002',
        'wipro',
        'Ana',
        'Owner',
        'Avda. de la Constitucin 2222',
        'Mxico D.F.',
        NULL,
        '05021',
        'Mexico',
        '(5) 555-4729',
        '(5) 555-3745'
    );

INSERT INTO customers
VALUES (
        '1003',
        'polaris',
        'Antonio',
        'Owner',
        'Mataderos  2312',
        'Mxico D.F.',
        NULL,
        '05023',
        'Mexico',
        '(5) 555-3932',
        '(5) 565-3532'
    );

INSERT INTO customers
VALUES (
        '1004',
        'virtuasa',
        'Thomas Hardy',
        'Sales Representative',
        '120 Hanover Sq.',
        'London',
        NULL,
        'WA1 1DP',
        'UK',
        '(171) 555-7788',
        '(171) 555-6750'
    );

INSERT INTO customers
VALUES (
        '1005',
        'genpact',
        'Frdrique Citeaux',
        'Marketing Manager',
        '24, place Klber',
        'Strasbourg',
        NULL,
        '67000',
        'France',
        '88.60.15.31',
        '88.60.15.32'
    );

CREATE TABLE
    employees (
        EmployeeID int(11) NOT NULL AUTO_INCREMENT,
        LastName varchar(20) NOT NULL,
        FirstName varchar(10) NOT NULL,
        JobTitle varchar(30) Default NULL,
        BirthDate datetime Default NULL,
        HireDate datetime Default NULL,
        Address varchar(60) Default NULL,
        City varchar(15) Default NULL,
        PostalCode varchar(10) Default NULL,
        Country varchar(15) Default NULL,
        Phone varchar(24) Default NULL,
        ReportsTo int(11) Default NULL,
        Salary float Default NULL,
        PRIMARY KEY (EmployeeID),
        KEY LastName (LastName),
        KEY ReportsTo (ReportsTo)
    );

INSERT INTO employees
VALUES (
        5001,
        'rao',
        'krishna',
        'Sales Representative',
        '1948-12-08 00:00:00',
        '1992-05-01 00:00:00',
        '507 - 20th Ave. E.Apt. 2A',
        'Seattle',
        '98122',
        'USA',
        '22255556',
        1234,
        30000
    );

INSERT INTO employees
VALUES (
        5002,
        'krishna',
        'ram',
        'Manager',
        '1950-10-06 00:00:00',
        '1995-06-02 00:00:00',
        '307 - 15th Ave. E.Apt',
        'Hyderabad',
        '500031',
        'India',
        '9849789648',
        1315,
        35000
    );

INSERT INTO employees
VALUES (
        5003,
        'hare',
        'ram',
        'Accountant',
        '1975-10-05 00:00:00',
        '1997-09-01 00:00:00',
        '107 Apt',
        'Secunderabad',
        '500031',
        'India',
        '9849755648',
        1415,
        45000
    );

INSERT INTO employees
VALUES (
        5004,
        'hare',
        'krishna',
        'Assistant Manager',
        '1980-08-06 00:00:00',
        '2002-10-05 00:00:00',
        '407 Apt',
        'Vijayawada',
        '520031',
        'India',
        '9888755648',
        2415,
        40000
    );

INSERT INTO employees
VALUES (
        5005,
        'murali',
        'mohan',
        'Manager',
        '1982-08-07 00:00:00',
        '2007-06-01 00:00:00',
        '237 Apt',
        'Hyderabad',
        '500031',
        'India',
        '9888695648',
        2695,
        45000
    );

CREATE TABLE
    orders(
        OrderID int(11) NOT NULL AUTO_INCREMENT,
        CustomerID varchar(5) Default NULL,
        EmployeeID varchar(5) Default NULL,
        OrderDate datetime Default NULL,
        RequiredDate datetime Default NULL,
        ShippedDate datetime Default NULL,
        ShipId int(11) Default NULL,
        ShipName varchar(40) Default NULL,
        ShipAddress varchar(60) Default NULL,
        PRIMARY KEY (OrderID)
    );

INSERT INTO
    orders(
        OrderID,
        CustomerID,
        EmployeeID,
        OrderDate,
        RequiredDate,
        ShippedDate,
        ShipId,
        ShipName,
        ShipAddress
    )
VALUES (
        9001,
        '1001',
        '5001',
        '1996-07-04 00:00:00',
        '1996-08-01 00:00:00',
        '1996-07-16 00:00:00',
        3,
        'Reims',
        'France'
    ), (
        9002,
        '1002',
        '5002',
        '1996-07-05 00:00:00',
        '1996-08-16 00:00:00',
        '1996-07-10 00:00:00',
        1,
        'Mnster',
        'Germany'
    ), (
        9003,
        '1003',
        '5003',
        '1998-11-06 00:00:00',
        '1998-12-04 00:00:00',
        '1998-11-08 00:00:00',
        3,
        'SP',
        'Brazil'
    ), (
        9004,
        '1004',
        '5004',
        '2002-11-12 00:00:00',
        '2002-11-26 00:00:00',
        '2002-11-18 00:00:00',
        2,
        'Lisboa',
        'Portugal'
    ), (
        9005,
        '1005',
        '5005',
        '2008-11-25 00:00:00',
        '2008-12-23 00:00:00',
        '2008-11-28 00:00:00',
        4,
        'Marseille',
        'France'
    );

CREATE TABLE
    categories(
        CategoryID int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
        CategoryName varchar(15) NOT NULL
    );

INSERT INTO
    categories(CategoryID, CategoryName)
VALUES (7001, 'electronics'), (7002, 'groceries'), (7003, 'clothing'), (7004, 'utensils'), (7005, 'bags');

CREATE TABLE
    products(
        ProductID int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        ProductName varchar(40) NOT NULL,
        SupplierID int(11) Default NULL,
        CategoryID int(11) Default NULL,
        QuantityPerUnit varchar(20) Default NULL,
        UnitPrice decimal(10, 4) Default NULL,
        UnitsInStock smallint(2) Default NULL,
        UnitsOnOrder smallint(2) Default NULL,
        ReorderLevel smallint(2) Default NULL,
        Discontinued bit(1) Default NULL
    );

INSERT INTO products
VALUES (
        6001,
        'computer',
        2001,
        7001,
        '25 computers',
        25000.0000,
        20,
        10,
        5,
        0
    );

INSERT INTO products
VALUES (
        6002,
        'laptop',
        2002,
        7002,
        '20 laptops',
        45000.0000,
        10,
        5,
        3,
        0
    );

INSERT INTO products
VALUES (
        6003,
        'pendrive',
        2003,
        7003,
        '35 pendrives',
        1000.0000,
        30,
        10,
        5,
        0
    );

INSERT INTO products
VALUES (
        6004,
        'memory card',
        2004,
        7004,
        '45 memory cards',
        500.0000,
        50,
        20,
        10,
        0
    );

INSERT INTO products
VALUES (
        6005,
        'headphones',
        2005,
        7005,
        '20 headphones',
        1000.0000,
        30,
        15,
        10,
        0
    );

CREATE TABLE
    shippers(
        ShipperID int(11) NOT NULL AUTO_INCREMENT,
        CompanyName varchar(40) NOT NULL,
        Phone varchar(24) Default NULL,
        PRIMARY KEY (ShipperID)
    );

INSERT INTO
    shippers (CompanyName, Phone)
VALUES ('samsung', '90000001'), ('lg', '6258215545'), ('redme', '6454545454'), ('nokia', '895633552'), ('oppo', '789658258');

CREATE TABLE
    suppliers(
        SupplierID int(11) NOT NULL AUTO_INCREMENT,
        CompanyName varchar(40) NOT NULL,
        ContactName varchar(30) Default NULL,
        ContactJobTitle varchar(30) Default NULL,
        Address varchar(60) Default NULL,
        Phone varchar(24) Default NULL,
        PRIMARY KEY (SupplierID)
    );

INSERT INTO
    suppliers(
        SupplierID,
        CompanyName,
        ContactName,
        ContactJobTitle,
        Address,
        Phone
    )
VALUES (
        2001,
        'samsung',
        'abc',
        'Salesman',
        'hyderabad',
        '987654321'
    ), (
        2002,
        'lg',
        'xyz',
        'manager',
        'delhi',
        '879654123'
    ), (
        2003,
        'redme',
        'pqr',
        'accountant',
        'agra',
        '688749234'
    ), (
        2004,
        'nokia',
        'uvw',
        'assistant manager',
        'vijayawada',
        '896547213'
    ), (
        2005,
        'oppo',
        'abcd',
        'executive',
        'secunderabad',
        '985462317'
    );

CREATE TABLE
    orderdetails(
        OrderID int(11) NOT NULL,
        ProductID int(11) NOT NULL,
        UnitPrice decimal(10, 4) NOT NULL,
        Quantity smallint(2) NOT NULL,
        PRIMARY KEY (OrderID, ProductID)
    );

INSERT INTO orderdetails VALUES(9001, 6001, 20000.0000, 10);

INSERT INTO orderdetails VALUES(9002, 6002, 25000.0000, 5);

INSERT INTO orderdetails VALUES(9003, 6003, 30000.0000, 10);

INSERT INTO orderdetails VALUES(9004, 6004, 23000.0000, 5);

create table
    Students (
        sid CHAR(20),
        name char (30),
        login char(20),
        age int,
        gpa REAL,
        UNIQUE (name, age),
        UNIQUE(login),
        CONSTRAINT StudentsKey PRIMARY KEY (sid)
    );

INSERT INTO
    Students (sid, name, login, age, gpa)
VALUES (
        53666,
        'Jones',
        'jones@cs',
        18,
        3.4
    ), (
        53688,
        'Smith',
        'Smith@ee',
        18,
        3.2
    ), (53667, 'Raj', 'Raj@cs', 20, 4.4), (
        53650,
        'Smith',
        'smith@math',
        19,
        3.8
    );

create table
    Enrolled (
        sid CHAR(20),
        cid CHAR(20),
        grade CHAR(2),
        PRIMARY KEY (sid, cid),
        FOREIGN KEY (sid) REFERENCES Students(sid)
    );

INSERT INTO
    Enrolled(sid, cid, grade)
VALUES (53666, 'History105', 'B'), (53650, 'Topology112', 'A'), (53688, 'Reggae203', 'B'), (53688, 'Carnatic101', 'C');