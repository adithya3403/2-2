-- rollback, savepoint and commit

-- 30-6-2022

-- create table demo(sid, sname, sage, sadd)

-- insert 3 rows

use today;

create table
    demo(
        sid int,
        sname varchar(20),
        sage int,
        sadd varchar(20)
    );

insert into demo values(1, 'rohit', 35, 'hyd');

insert into demo values(2, 'virat', 33, 'secbad');

insert into demo values(3, 'ravi', 32, 'chennai');

insert into demo values(4, 'baz', 50, 'nz');

select * from demo;

set autocommit = 0;

select * from demo;

delete from demo where sid = 3;

select * from demo;

rollback;

select * from demo;

delete from demo where sid = 2;

commit;

rollback;

select * from demo;

start transaction;

insert into demo values(5, 'sachin', 40, 'mumbai');

insert into demo values(6, 'manish', 45, 'delhi');

insert into demo values(7, 'saurav', 43, 'pune');

select * from demo;

savepoint s1;

delete from demo where sid=6;

select * from demo;

rollback to s1;

SELECT * from demo;

savepoint s2;

insert into demo values(8, 'bhuvi', 35, 'hyd');

insert into demo values(9, 'ashwin', 38, 'chennai');

select * from demo;

rollback to s2;

select * from demo;

-- demo1 and demo2

create table demo1(sid int);

create table demo2(sid int);

insert into demo1 values(1);

insert into demo1 values(2);

insert into demo1 values(4);

insert into demo1 values(5);

insert into demo2 values(1);

insert into demo2 values(6);

insert into demo2 values(7);

insert into demo2 values(8);

select * from demo1;

select * from demo2;

select demo1.sid from demo1 except select demo2.sid from demo2;

-- the except operator is used to combine two select statements and

-- returns the rows from first select statement that are not returned by

-- the second select statement

SELECT demo1.sid
from demo1
where demo1.sid not in (
        select demo2.sid
        from demo2
    );