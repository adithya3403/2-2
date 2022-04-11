
SHOW DATABASES;
USE SBR;
SHOW TABLES;


CREATE TABLE Sailors(
    Sid INT PRIMARY KEY,
    Sname VARCHAR(20),
    Sage FLOAT,
    Srating INT
);
DESC Sailors;
INSERT INTO Sailors VALUES(22, 'Dustia', 45.0, 7);
INSERT INTO Sailors VALUES(29, 'Brutus', 33.0, 1);
INSERT INTO Sailors VALUES(31, 'Lubber', 55.5, 8);
INSERT INTO Sailors VALUES(32, 'Andy', 25.5, 8);
INSERT INTO Sailors VALUES(58, 'Rusty', 35.0, 10);
INSERT INTO Sailors VALUES(64, 'Haratio', 35.0, 7);
INSERT INTO Sailors VALUES(71, 'Forbes', 16.0, 10);
INSERT INTO Sailors VALUES(74, 'Haratio', 35.0, 9);
INSERT INTO Sailors VALUES(85, 'Ant', 25.5, 3);
INSERT INTO Sailors VALUES(95, 'Bob', 63.5, 3);
SELECT * FROM Sailors;


CREATE TABLE Boats(
    Bid INT PRIMARY KEY,
    Bname VARCHAR(20),
    Bcolor VARCHAR(20)
);
DESC Boats;
INSERT INTO Boats VALUES(101, 'Interlake', 'Blue');
INSERT INTO Boats VALUES(102, 'Interlake', 'Red');
INSERT INTO Boats VALUES(103, 'Clipper', 'Green');
INSERT INTO Boats VALUES(104, 'Marine', 'Red');
SELECT * FROM Boats;


CREATE TABLE Reserves(
    Sid INT,
    Bid INT,
    day DATE,
    PRIMARY KEY(Sid, Bid, day),
    FOREIGN KEY(Sid) REFERENCES Sailors(Sid),
    FOREIGN KEY(Bid) REFERENCES Boats(Bid)
);
DESC Reserves;
INSERT INTO Reserves VALUES(22, 101, '1998-10-10');
INSERT INTO Reserves VALUES(22, 102, '1998-10-10');
INSERT INTO Reserves VALUES(22, 103, '1998-08-10');
INSERT INTO Reserves VALUES(22, 104, '1998-07-10');
INSERT INTO Reserves VALUES(31, 102, '1998-10-11');
INSERT INTO Reserves VALUES(31, 103, '1998-06-11');
INSERT INTO Reserves VALUES(31, 104, '1998-12-11');
INSERT INTO Reserves VALUES(64, 101, '1998-05-09');
INSERT INTO Reserves VALUES(64, 102, '1998-08-09');
INSERT INTO Reserves VALUES(74, 103, '1998-08-09');
SELECT * FROM Reserves;