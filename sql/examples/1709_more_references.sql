CREATE TABLE tablea (
    a_id     NUMBER NOT NULL,
    a_name   VARCHAR2(100)
);

--DML   insert, update, delete
--DQL   select
--DDL   create, alter, drop
--DCL   grant, revoke
--TCL   rollback, commit, savepoint

select * from TableA;
delete from TableA;
insert into TableA values (1, 'IT');
insert into TableA values (2, 'Logan');
insert into TableA values (3, 'Guardians of the galaxy');
insert into TableA values (4, 'Star wars - seventh one');
insert into TableA values (5, 'Planet of the apes');
insert into TableA values (6, 'Dunkirk');
insert into TableA values (7, 'Kingsman');
insert into TableA values (8, 'Lord of the rings');
insert into TableA values (9, 'Gladiator');

update tablea set A_ID = 10 where A_ID = 9;

ALTER TABLE TABLEA 
ADD CONSTRAINT AID_PK PRIMARY KEY (A_ID);

UPDATE TABLEA SET A_NAME = 'FAST AND FURIOUS' WHERE A_ID = 9;

ALTER TABLE TABLEA 
RENAME COLUMN A_NAME TO MOVIE_NAMES; 

ALTER TABLE TABLEA 
RENAME COLUMN A_ID TO M_ID; 

CREATE TABLE FLASHCARDS(
FC_ID NUMBER NOT NULL,
FC_QUESTION VARCHAR2 (100),
FC_ANSWERS VARCHAR2(100),
CONSTRAINT FCID_PK PRIMARY KEY (FC_ID)
);

INSERT INTO FLASHCARDS VALUES (1, 'CAN YOU OVERLOAD A MAIN METHOD?','YES');
INSERT INTO FLASHCARDS VALUES (2, 
'HOW DO YOU CREATE A THREAD?',
'EXTEND THREAD CLASS OR IMPLEMENT RUNNABLE INTERFACE');

INSERT INTO FLASHCARDS VALUES (3, 'WHAT IS STATIC POLYMORPHISM?',
'OVERLOADING - SAME METHOD WITH DIFFERENT NUMBER, ORDER, DATA TYPE OF PARAMETERS');

--alternative syntax for insert 
INSERT INTO FLASHCARDS (FC_ID, FC_ANSWERS, FC_QUESTION)
VALUES (1,'YES', 'CAN YOU OVERLOAD A MAIN METHOD?');

SELECT * FROM FLASHCARDS;

DROP TABLE FLASHCARDS; 

COMMIT;

create user testuser IDENTIFIED by p4ssw0rd;
grant connect, resource to testuser;
--GRANT DBA TO testuser WITH ADMIN OPTION;

select table_name from all_tables;
desc flashcards;
select * from dual;

create table A(ID NUMBER (10) PRIMARY KEY,NAME VARCHAR2(20));
create table B(ID NUMBER (10) PRIMARY KEY,NAME VARCHAR2(20));
create table C(ID NUMBER (10) PRIMARY KEY,NAME VARCHAR2(20));
create table D(ID NUMBER (10) PRIMARY KEY,NAME CHAR(25));

insert into A values (1, 'Tom Brady');
insert into A values (2, 'Russell Wilson');
insert into A values (3, 'Levon Bell');
insert into A values (4, 'Peyton Manning');
insert into A values (5, 'Cam Newton');
insert into B values (1, 'Tom Brady');
insert into B values (3, 'Levon Bell');
insert into B values (5, 'Cam Newton');
insert into B values (6, 'Marshawn Lynch');
insert into B values (7, 'DeSean Jackson');
insert into C values (1, 'Tom Brady');
insert into C values (2, 'Russell Wilson');
insert into C values (3, 'Levon Bell');
insert into C values (6, 'Marshawn Lynch');
insert into C values (8, 'Robert Griffin');
insert into C values (9, 'Eli Manning');

insert into D values (1, 'Tom Brady');
insert into D values (2, 'Russell Wilson');
insert into D values (3, 'Levon Bell');
insert into D values (4, 'Peyton Manning');
insert into D values (5, 'Cam Newton');
insert into D values (6, 'Marshawn Lynch');
insert into D values (7, 'DeSean Jackson');
insert into D values (8, 'Robert Griffin');
insert into D values (9, 'Eli Manning');
insert into D values (10, 'Greg Olsen');

select * from a;
select * from b;
select * from c;

--joins --inner join, outer joins (left, right, full)
--inner join
--mrtg_sngl_fm_mth_hst_dtls xyz
SELECT * FROM A INNER JOIN B ON A.ID = B.ID;
SELECT * FROM A tablea_sdet_rds_1709
INNER JOIN B tableb_sdet_rds_1709
ON tablea_sdet_rds_1709.ID = tableb_sdet_rds_1709.ID;

SELECT A.ID, A.NAME FROM A INNER JOIN B ON A.ID = B.ID;
SELECT A.ID, A.NAME FROM A INNER JOIN B ON A.NAME = B.NAME;
--set operators --intersect, union, union all, minus
--Intersect
select * from A
intersect
select * from B;

--join more than 2 tables
SELECT * FROM A INNER JOIN B ON A.ID = B.ID INNER JOIN C on B.ID = C.ID;
SELECT * FROM A INNER JOIN B ON A.ID = B.ID INNER JOIN C on B.NAME = C.NAME;

SELECT *
FROM a
    LEFT JOIN b ON a.id = b.id;
    
SELECT * FROM B LEFT JOIN A ON A.ID = B.ID;

SELECT * FROM A RIGHT JOIN B ON A.ID = B.ID;
SELECT * FROM B RIGHT JOIN A ON A.ID = B.ID;

SELECT
    *
FROM
    a
    INNER JOIN b ON a.id = b.id     --4 COLUMNS, 3 ROWS
    INNER JOIN c ON b.id = c.id     --6 COLUMNS, 2 ROWS
    LEFT JOIN c ON c.id = a.id      --8 columns, 2 rows
    RIGHT JOIN d ON d.id = c.id;    --10 columns, 10 rows
;

SELECT
    a.id, b.name, d.id, d.name
FROM
    a
    INNER JOIN b ON a.id = b.id     --4 COLUMNS, 3 ROWS
    INNER JOIN c ON b.id = c.id     --6 COLUMNS, 2 ROWS
    LEFT JOIN c ON c.id = a.id      --8 columns, 2 rows
    RIGHT JOIN d ON d.id = c.id;    --10 columns, 10 rows


SELECT * FROM A 
FULL JOIN B 
ON A.ID = B.ID;     --4 COLUMNS, 7 ROWS

SELECT * FROM A 
INNER JOIN B
ON A.ID = B.ID;     --4 COLUMNS, 3 ROWS

SELECT * FROM C
INNER JOIN D
ON C.ID = D.ID;     --4 COLUMNS, 6 ROWS

SELECT *
FROM a
    INNER JOIN b ON a.id = b.id
    FULL OUTER JOIN 
        (SELECT D.ID, D.NAME
        FROM
            c
            INNER JOIN d ON c.id = d.id) E
    ON a.ID = E.ID;       --8 COLUMNS, 7 ROWS
    

select * from a full join c on a.id= c.id;

select * from a
union 
select * from  c;   --2 columns, 8 rows

select * from a
union all
select * from  c;   --2 columns, 11 rows

select id, name from a
union all
select id, name from  c   --2 columns, 11 rows
order by id;

--wild card characters
-- % means multiple character matching
-- _ single character matching
-- like is the keyword used for pattern matching using wild card characters
SELECT * FROM D WHERE D.NAME LIKE 'L%';
SELECT * FROM D WHERE D.NAME LIKE '%Manning%';
SELECT * FROM D WHERE D.NAME LIKE 'R%';
SELECT * FROM D WHERE D.NAME LIKE '%Ma%';
SELECT * FROM D WHERE D.NAME LIKE '%ton%';
SELECT trim(d.name) FROM D WHERE trim(D.NAME) LIKE '%Brad_';


--functions --scalar and aggregate
--scalar functions
--upper, lower, length, substr, concat, instr, ltrim, rtrim
select * from d;
select d.id, upper(d.name) from d;
select d.id, lower(d.name) from d;

--2 characters from name and 2 characters another name column & concatenate both
select concat (concat (upper(substr(d.name, 1,3)), ' '), 
        upper(substr(a.name, 1,2))) 
from d
full join a on a.id = d.id 
where a.name is not null
and d.name is not null;

select length(d.name) from d;
select length(ltrim(d.name)) from d;
select length(rtrim(d.name)) from d;
select length(trim(d.name)) from d;

select * from dual;
select instr('HelloWorld','World') from dual;
select instr(trim(d.name),'Manning') from d;
desc d;

select * from invoice where customerid=5;
select * from invoice where invoiceid=122;
select count(*) from invoice where customerid=5;
desc invoice;

select * from customer where customerid=5;
select count(*) from customer where customerid=5;
desc customer;

select count(*) from INVOICELINE where invoiceid=122;
select * from INVOICELINE inner join invoice 
on invoice.INVOICEID = INVOICELINE.INVOICEID
where invoice.CUSTOMERID = 5
;

desc invoiceline;

select customer.customerid, invoice.INVOICEID from invoice 
    inner join customer 
    on invoice.CUSTOMERID = customer.CUSTOMERID
    inner join INVOICELINE
    on invoice.INVOICEID = INVOICELINE.INVOICEID
    where invoice.CUSTOMERID = 5
    ;

delete from (select * from invoice 
    inner join customer 
    on invoice.CUSTOMERID = customer.CUSTOMERID
    inner join INVOICELINE
    on invoice.INVOICEID = INVOICELINE.INVOICEID
    where invoice.CUSTOMERID = 5
    );

rollback;

select * from invoiceline where INVOICEID = 100;
delete from invoiceline where INVOICEID = 100;

select * from invoice where invoiceid = 100;
delete from invoice where invoiceid = 100;

-- always turn this on for sys out
set serveroutput on;

--Stored procedures or transactional store procedures
create or replace procedure delete_invoice (inve Number)
as
begin
    delete from invoiceline where INVOICEID = inve;
    delete from invoice where invoiceid = inve;
    commit;
end;
/

exec delete_invoice(100);
exec delete_invoice(122);

create or replace procedure HelloWorld
is
begin
    DBMS_OUTPUT.PUT_LINE('hello world!!');
end;
/
--1st approach
exec HELLOWORLD;

--2nd approach
begin
    HELLOWORLD;
end;
/

--functions
create or replace function multiply(x Number, y Number)
return Number
as results Number;
begin
    results := x * y;
    return results;
end;
/

declare                 --approach 1 to call a function
    toPrint Number;
begin
    toPrint := multiply(10,20);
    DBMS_OUTPUT.PUT_LINE(toPrint);
end;
/
select multiply (20,30) from dual;  --approach 2 to call a function

select avg(total) from invoice;
select * from invoiceline;
select count(invoiceline.QUANTITY), invoiceline.invoiceid from invoiceline 
group by invoiceline.quantity, invoiceline.invoiceid;

select sum(unitprice)/count(quantity) from invoiceline;
--group by invoiceid;

create or replace function invoice_average return number
is
    average number;
begin
    select sum(unitprice)/count(quantity) into average from invoiceline;
    return average;
end;
/
select invoice_average from dual;

Create sequence a_seq
	minvalue 1
	maxvalue 1000
	start with 1
	increment by 1;

-- post increament
select a_seq.currval, A_SEQ.NEXTVAL, A_SEQ.CURRVAL, A_SEQ.NEXTVAL from dual;

--post increament
select A_SEQ.currval from dual;
select A_SEQ.nextval from dual;

-- CHANGING CONNECTION TO MY SCHEMA. DON'T WANT TO CREATE A TABLE IN CHINOOK SCHEMA
CREATE TABLE ACTIVE_PLAYERS (
    PLAYER_ID NUMBER(10),
    PLAYER_NAME VARCHAR2(20),
    CREATION_TIME TIMESTAMP
);

CREATE TABLE PLAYERS_AUDIT_TRAIL(
    PLAYER_NAME VARCHAR2(20),
    CREATION_TIME TIMESTAMP,
    CREATED_USER VARCHAR2(10)
);

--ALTER TABLE table_name
--ADD column_name datatype;
--(add, modify, drop)

ALTER TABLE PLAYERS_AUDIT_TRAIL
modify CREATED_USER varchar2(20);


Create sequence RDS_SEQ
	minvalue 1
	maxvalue 1000
	start with 1
	increment by 1;


select * from active_players;
select * from PLAYERS_AUDIT_TRAIL;

create or replace trigger insert_players
after insert on ACTIVE_PLAYERS for each row
begin
    insert into PLAYERS_AUDIT_TRAIL values 
    (:new.PLAYER_NAME, :new.CREATION_TIME, user );
end;
/

create or replace trigger DELETE_PLAYERS
BEFORE DELETE on ACTIVE_PLAYERS for each row
begin
    insert into PLAYERS_AUDIT_TRAIL values 
    (:new.PLAYER_NAME, :new.CREATION_TIME, user );
end;
/

INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Collin Kapernick', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Andy Dalton', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Eric Decker', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Joe Flacco', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Andrew Luck', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Matt Ryan', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Drew Brees', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'AJ Green', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Antonio Gates', SYSTIMESTAMP);

DELETE FROM ACTIVE_PLAYERS;

-- CURSORS
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
--cursor as a pass by reference
CREATE OR REPLACE PROCEDURE EMPLOYEE_NAMES(JOHN_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN JOHN_CURSOR FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE
    EMPLOYEE_CURSOR SYS_REFCURSOR;
    FIRST_NAME VARCHAR2(30);
    LAST_NAME VARCHAR2(30);
BEGIN
    EMPLOYEE_NAMES(EMPLOYEE_CURSOR);
    LOOP
        FETCH EMPLOYEE_CURSOR INTO FIRST_NAME, LAST_NAME;
        EXIT WHEN EMPLOYEE_CURSOR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(UPPER(LAST_NAME)|| ',' || UPPER(FIRST_NAME));
    END LOOP;
END;
/

SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-1968' ;
--CURSOR RETURN FROM FUNCTION
CREATE OR REPLACE FUNCTION AFTER1968 RETURN SYS_REFCURSOR
IS 
EMPLOYEE_CURSOR SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEE_CURSOR  FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-1968' ;
    RETURN EMPLOYEE_CURSOR;
END;
/
SELECT AFTER1968 FROM DUAL;


--CHANGING BACK TO MY SCHEMA
CREATE or replace VIEW JOIN_VW2 AS
    SELECT
    a.id as AID, a.name as ANAME, b.ID as BID, b.NAME as BNAME,
    c.id as CID, c.NAME as CNAME, d.ID as DID, d.NAME as DNAME
FROM
    a
    INNER JOIN b ON a.id = b.id     --4 COLUMNS, 3 ROWS
    INNER JOIN c ON b.id = c.id     --6 COLUMNS, 2 ROWS
    LEFT JOIN c ON c.id = a.id      --8 columns, 2 rows
    RIGHT JOIN d ON d.id = c.id;    --10 columns, 10 rows

create or replace view join_vw as 
SELECT 
    a.id as AID, a.name as ANAME, b.ID as BID, b.NAME as BNAME,
    E.ID as EID, E.NAME as ENAME
FROM a
    INNER JOIN b ON a.id = b.id
    FULL OUTER JOIN 
        (SELECT D.ID, D.NAME
        FROM
            c
            INNER JOIN d ON c.id = d.id) E
    ON a.ID = E.ID;       --8 COLUMNS, 7 ROWS

create or replace view helloworld as
select * from A;

select * from JOIN_VW2;
select * from JOIN_VW;

create index players_idx
on active_players (player_id);

select * from active_players;

commit;

savepoint ap_921201742845;

INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Kirk Cousin', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Aaron Rodgers', SYSTIMESTAMP);

savepoint ap_921201743125;

INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'tom', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'mike', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'peter', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'john', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'yuvi', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'frank', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'joe', SYSTIMESTAMP);

savepoint ap_98w9e46t;


rollback to SAVEPOINT ap_921201743125;


Create table employee 
      (
      emp_id number(10) primary key,
      emp_name varchar2(200),
      salary number (38)
      );
      
insert into employee values (1, 'A', 100);
insert into employee values (2, 'A', 200);
insert into employee values (3, 'A', 300);
insert into employee values (4, 'A', 400);
insert into employee values (5, 'A', 500);
insert into employee values (6, 'A', 600);
insert into employee values (7, 'A', 700);

 Select emp_name, salary from
  (select emp_name, salary ,Row_Number() over(order by salary desc) 
    as myrow from employee) abc
  where abc.myrow = 3;
  
  CREATE USER LOGIN_TEST_DB IDENTIFIED BY p4ssw0rd;
GRANT DBA TO LOGIN_TEST_DB WITH ADMIN OPTION;

--chinook examples
select * from invoice;

--count, min, max, sum, avg
select count(*) from invoice;
select count(*) from invoiceline;
select sum(i.TOTAL) from invoice i;
select AVG(i.TOTAL) from invoice i;
select MAX(i.TOTAL) from invoice i;
select MIN(i.TOTAL) from invoice i;

select * from invoice i 
order by i.BILLINGCITY;

select i.BILLINGCITY from invoice i
group by i.BILLINGCITY;

select count(distinct(i.BILLINGCITY)) from invoice i;
select count(distinct(i.INVOICEDATE)) from invoice i;
select count(distinct(a.TITLE)) from album a;
select count(distinct(a.NAME)) from artist a;

SELECT
     c.FIRSTNAME,  sum(il.quantity), sum(il.UNITPRICE)
FROM
    invoice i
    INNER JOIN invoiceline il ON i.invoiceid = il.invoiceid
    inner join customer c on c.customerid = i.customerid 
    where i.CUSTOMERID > 10
    group by c.FIRSTNAME, il.quantity
    having sum(il.quantity) > 30
    order by c.FIRSTNAME
    ;
    
select * from INVOICELINE;

