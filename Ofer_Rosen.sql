--2.1

SELECT * FROM CHINOOK.EMPLOYEE;

SELECT * FROM CHINOOK.EMPLOYEE 
WHERE LASTNAME='King';

SELECT * FROM CHINOOK.EMPLOYEE 
WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

--2.2
SELECT * FROM CHINOOK.ALBUM
ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CHINOOK.CUSTOMER
ORDER BY CITY ASC;

--2.3

INSERT INTO CHINOOK.GENRE (GENREID,NAME) VALUES (26,'Ambient'); 
INSERT INTO CHINOOK.GENRE (GENREID,NAME) VALUES (27,'Psychedelic');

INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (1000,'Rosen','Ofer'); 
INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (1001,'Smith','John'); 

INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES (1000,'Rosen','Ofer','aaa@bbb.com'); 
INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES (1001,'Smith','John','aaa2@bbb.com');

--2.4
UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME='Robert', LASTNAME='Walker'
WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';

UPDATE CHINOOK.ARTIST
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';

--2.5

SELECT * FROM CHINOOK.INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6

SELECT * FROM CHINOOK.INVOICE 
WHERE TOTAL BETWEEN 15 AND 50;

SELECT * FROM CHINOOK.EMPLOYEE 
WHERE HIREDATE BETWEEN '1-JUN-2003' AND '1-MAR-2004';

--2.7

DELETE FROM CHINOOK.INVOICELINE WHERE(INVOICEID=50)OR(INVOICEID=61)OR(INVOICEID=116)OR(INVOICEID=245)
OR(INVOICEID=268)OR(INVOICEID=290)OR(INVOICEID=342);
DELETE FROM CHINOOK.INVOICE WHERE CUSTOMERID=32;
DELETE FROM CHINOOK.CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walker';

--3.1
--part 1
create or replace FUNCTION OFERTIME 
RETURN VARCHAR2 is
  timee VARCHAR2(40);
BEGIN
SELECT TO_CHAR (CURRENT_TIMESTAMP, 'HH24:MM:SS, Day, Month, DD, YYYY')
INTO timee FROM DUAL;
RETURN timee;
END;
/
select OFERTIME() from dual;

--part 2

create or replace FUNCTION MEDIALENGTH (x in number)
RETURN number is
  lll number;
BEGIN
SELECT length(NAME) 
INTO lll FROM CHINOOK.MEDIATYPE WHERE MEDIATYPEID=x;
RETURN lll;
END MEDIALENGTH;
/
--MEDIATYPEID can be any value from 1 to 5
select MEDIALENGTH(2) from dual;

--3.2 part 1
create or replace FUNCTION AVERAGETOTAL
RETURN number is
  x number;
BEGIN
SELECT AVG(TOTAL) 
INTO x FROM CHINOOK.INVOICE;
RETURN x;
END AVERAGETOTAL;
/
select AVERAGETOTAL() from dual;

/*
3.2 part 2
returns the NAMES of the most expensive tracks (there are multiple "most expensive" tracks)
*/
create or replace type atype force as object(Name varchar2(40));
/
create or replace type t_atype as table of atype;
/
create or replace FUNCTION mtrack
 RETURN t_atype PIPELINED as
BEGIN
   FOR A IN (SELECT NAME FROM CHINOOK.TRACK where 
UNITPRICE=(SELECT MAX(UNITPRICE) FROM CHINOOK.TRACK) )
LOOP
      PIPE ROW (atype(A.NAME));
   END LOOP;
RETURN;
END mtrack;
/
SELECT * FROM TABLE(mtrack());

--3.3
create or replace FUNCTION AVERAGE2
RETURN number is
  x number;
BEGIN
SELECT AVG(UNITPRICE) 
INTO x FROM CHINOOK.INVOICELINE;
RETURN x;
END AVERAGE2;
/
select AVERAGE2() from dual;

--3.4
create or replace type emptype force as object(First_Name varchar2(20),
Last_Name varchar2(20),Birthdate   date);
/
create or replace type t_emptype as table of emptype;
/
create or replace FUNCTION E1968
 RETURN t_emptype PIPELINED as
BEGIN
   FOR A IN (SELECT LASTNAME, FIRSTNAME, BIRTHDATE FROM CHINOOK.EMPLOYEE WHERE BIRTHDATE>='1-JAN-1969') LOOP
      PIPE ROW (emptype(A.LASTNAME, A.FIRSTNAME,A.BIRTHDATE));
   END LOOP;
RETURN;
END E1968;
/
SELECT * FROM TABLE(E1968());

--4.1

CREATE OR REPLACE PROCEDURE FIRSTLASTNAME(cursor_ OUT SYS_REFCURSOR) IS 
BEGIN
OPEN cursor_ FOR 
SELECT lastname,firstname 
FROM CHINOOK.EMPLOYEE; 
END FIRSTLASTNAME;
/
---This is the beginning of 
DECLARE
resultSet  SYS_REFCURSOR;
v_last      CHINOOK.EMPLOYEE.LASTNAME%TYPE;
  v_first      CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
BEGIN
firstlastname(resultSet);
--viewing the results on DBMS output
DBMS_OUTPUT.PUT_LINE(rpad('Last Name',12) || 'First Name');
LOOP
    FETCH resultSet
    INTO  v_last, v_first;
    EXIT WHEN resultSet%NOTFOUND;
        --DBMS_OUTPUT.PUT_LINE(v_last ||chr(9)||chr(9)||'|'||chr(9)|| v_first);
        DBMS_OUTPUT.PUT_LINE(rpad(v_last,12) || v_first);
  END LOOP;
  CLOSE resultSet;
END;
 /
/*
4.2
part 1
Updates title of "Ofer Rosen" as "CEO"!
*/

CREATE OR REPLACE PROCEDURE updatetable
IS
BEGIN
  UPDATE CHINOOK.EMPLOYEE SET TITLE='CEO' where EMPLOYEEID = 1000;
--COMMIT;
END;
/
-- updating priviliges must be granted
GRANT UPDATE ON CHINOOK.EMPLOYEE TO PUBLIC;
BEGIN
updatetable;
End;
/

/*
4.2 part2
The procedure will accept the employeeID as input and return ALL the managers
of the employee.
*/
CREATE OR REPLACE PROCEDURE whoarethebosses(
x in CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE)AS

   fname2 CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
   lname2 CHINOOK.EMPLOYEE.LASTNAME%TYPE;
   title1 CHINOOK.EMPLOYEE.TITLE%TYPE;
   title2 CHINOOK.EMPLOYEE.TITLE%TYPE;
BEGIN

select TITLE into title1
from CHINOOK.EMPLOYEE where EMPLOYEEID = x;

/*
A nested if statement which first checks if the employee is the CEO
if YES - output Long live the king!
if not - output the details of the CEO 
(the CEO is manager of everyone except himself)
Afterwards it checks if the employee is the General Manager 
(the General Manager is in charge of everyone except the CEO)
Afterwards the if statements proceed down the chain of command

NOTE - This excercise can also be accomplished using the REPORTSTO column
*/

If (title1='CEO') then
DBMS_OUTPUT.PUT_LINE('Long live the King!');
end if;
  If (title1!='CEO') then
  DBMS_OUTPUT.PUT_LINE(rpad('First Name',12)||rpad('Last Name',12)||'Title');
  
        select LASTNAME,FIRSTNAME,TITLE 
        into lname2,fname2,title2
        from CHINOOK.EMPLOYEE where title='CEO';
        DBMS_OUTPUT.PUT_LINE(rpad(fname2,12)||rpad(lname2,12)||title2);
  if (title1!='General Manager') then
        select LASTNAME,FIRSTNAME,TITLE 
        into lname2,fname2,title2
        from CHINOOK.EMPLOYEE where title='General Manager';
        DBMS_OUTPUT.PUT_LINE(rpad(fname2,12)||rpad(lname2,12)||title2);
  if(title1='IT Staff')then
        select LASTNAME,FIRSTNAME,TITLE 
        into lname2,fname2,title2
        from CHINOOK.EMPLOYEE where title='IT Manager';
        DBMS_OUTPUT.PUT_LINE(rpad(fname2,12)||rpad(lname2,12)||title2);
 end if;
  if(title1='Sales Support Agent')then
        select LASTNAME,FIRSTNAME,TITLE 
        into lname2,fname2,title2
        from CHINOOK.EMPLOYEE where title='Sales Manager';
        DBMS_OUTPUT.PUT_LINE(rpad(fname2,12)||rpad(lname2,12)||title2);
 end if;  
end if;       
end if;
END;

/
--Executes the procedure
--Outputs the chain of command above EmployeeID 7
BEGIN
whoarethebosses(7);
End;
/

--4.3

CREATE OR REPLACE PROCEDURE whoisthecustomer(
x in CHINOOK.CUSTOMER.CUSTOMERID%TYPE,
fname out CHINOOK.CUSTOMER.FIRSTNAME%TYPE,
lname out CHINOOK.CUSTOMER.LASTNAME%TYPE,
cpany out CHINOOK.CUSTOMER.COMPANY%TYPE)AS

BEGIN

select FIRSTNAME,LASTNAME,COMPANY into fname,lname,cpany
from CHINOOK.CUSTOMER where CUSTOMERID = x;

/*
The point of the excercise is to use output paramaters in the procedure.
Therefore the DBMS outputs will not be used here
DBMS_OUTPUT.PUT_LINE(rpad('First Name',12)||rpad('Last Name',12)||'Comapny');       
DBMS_OUTPUT.PUT_LINE(rpad(fname,12)||rpad(lname,12)||cpany);
*/
END;
/

/*
Executes the procedure
In the case below, outputs information regarding customerID=11
*/
DECLARE
fname CHINOOK.CUSTOMER.FIRSTNAME%TYPE;
lname CHINOOK.CUSTOMER.LASTNAME%TYPE;
cpany CHINOOK.CUSTOMER.COMPANY%TYPE;
BEGIN 
whoisthecustomer(11,fname,lname,cpany);
DBMS_OUTPUT.PUT_LINE(rpad('First Name',12)||rpad('Last Name',12)||'Comapny');       
DBMS_OUTPUT.PUT_LINE(rpad(fname,12)||rpad(lname,12)||cpany);
End;
/

-- 5.0 part 1

CREATE OR REPLACE PROCEDURE deleteinvoiceid(
x in CHINOOK.INVOICE.INVOICEID%TYPE)AS
BEGIN
DELETE FROM CHINOOK.INVOICE WHERE INVOICEID = x;
COMMIT;
END;
/
--Must be performed prior to compilation and execution of procedure
--grant all necessay privileges
GRANT ALL ON CHINOOK.INVOICE to PUBLIC;
--remove the integrity constraint
alter table CHINOOK.INVOICELINE DISABLE constraint FK_INVOICELINEINVOICEID;
BEGIN
deleteinvoiceid(120);
End;
/

-- 5.0 part 2

CREATE OR REPLACE PROCEDURE insertcustomer(
ident in CHINOOK.CUSTOMER.CUSTOMERID%TYPE,
fname in CHINOOK.CUSTOMER.FIRSTNAME%TYPE,
lname in CHINOOK.CUSTOMER.LASTNAME%TYPE,
mail in CHINOOK.CUSTOMER.EMAIL%TYPE)AS
BEGIN
INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME,EMAIL) 
VALUES (ident,fname,lname,mail);
COMMIT;
END;
/
--Must be performed prior to compilation and execution of procedure
--grant all necessay privileges
GRANT ALL ON CHINOOK.CUSTOMER to PUBLIC;

BEGIN 
insertcustomer(777,'John','Doe','aaa@bbb.com');
End;
/

---6.0 part 1
CREATE OR REPLACE TRIGGER newemployee
AFTER INSERT ON CHINOOK.EMPLOYEE
BEGIN
DBMS_OUTPUT.PUT_LINE('A new member has joined the team!');
END;
/
--testing the trigger
BEGIN
INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (445,'Jack','Bower');
END;
/
---6.0 part 2
CREATE OR REPLACE TRIGGER newalbumrow
AFTER UPDATE ON CHINOOK.ALBUM FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('A new row has been updated!');
END;
/
BEGIN
UPDATE CHINOOK.ALBUM SET ALBUMID=354,TITLE='aba',ARTISTID=100
WHERE(ALBUMID=354);
END;
/
---6.0 part 3
CREATE OR REPLACE TRIGGER deletecustomer
AFTER DELETE ON CHINOOK.CUSTOMER FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('A customer has been removed!');
END;
/
BEGIN
DELETE FROM CHINOOK.CUSTOMER WHERE FIRSTNAME='Joakim';
END;
/
--7.1

SELECT CUSTOMER.CUSTOMERID,CUSTOMER.LASTNAME,CUSTOMER.FIRSTNAME,INVOICE.INVOICEID
FROM CHINOOK.CUSTOMER 
INNER JOIN CHINOOK.INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
ORDER BY CUSTOMERID;

--7.2
SELECT CUSTOMER.CUSTOMERID,CUSTOMER.LASTNAME,CUSTOMER.FIRSTNAME,INVOICE.INVOICEID,INVOICE.TOTAL
FROM CHINOOK.CUSTOMER 
FULL OUTER JOIN CHINOOK.INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
ORDER BY CUSTOMERID;

--7.3
SELECT ARTIST.NAME,ALBUM.TITLE
FROM CHINOOK.ALBUM
RIGHT JOIN CHINOOK.ARTIST
ON ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME;

--7.4
SELECT ARTIST.NAME,ALBUM.TITLE
FROM CHINOOK.ALBUM
CROSS JOIN CHINOOK.ARTIST
ORDER BY ARTIST.NAME ASC;

--7.5
SELECT aa.LASTNAME, aa.FIRSTNAME ,b.LASTNAME,b.FIRSTNAME,b.REPORTSTO
FROM CHINOOK.EMPLOYEE aa, CHINOOK.EMPLOYEE b
WHERE aa.REPORTSTO = b.REPORTSTO;

--7.6
SELECT ALBUM.ALBUMID,ARTIST.ARTISTID, CUSTOMER.CUSTOMERID, EMPLOYEE.EMPLOYEEID,
GENRE.GENREID,INVOICE.INVOICEID,INVOICELINE.INVOICELINEID,MEDIATYPE.MEDIATYPEID,
PLAYLIST.PLAYLISTID,PLAYLISTTRACK.PLAYLISTID,TRACK.TRACKID
FROM CHINOOK.ALBUM 
INNER JOIN CHINOOK.ARTIST
    ON ALBUM.ALBUMID = ARTIST.ARTISTID
INNER JOIN CHINOOK.CUSTOMER
    ON ARTIST.ARTISTID=CUSTOMER.CUSTOMERID
INNER JOIN CHINOOK.EMPLOYEE
    ON CUSTOMER.CUSTOMERID=EMPLOYEE.EMPLOYEEID
INNER JOIN CHINOOK.GENRE
    ON EMPLOYEE.EMPLOYEEID=GENRE.GENREID
INNER JOIN CHINOOK.INVOICE
    ON GENRE.GENREID=INVOICE.INVOICEID
INNER JOIN CHINOOK.INVOICELINE
    ON INVOICE.INVOICEID=INVOICELINE.INVOICELINEID
INNER JOIN CHINOOK.MEDIATYPE
    ON INVOICELINE.INVOICELINEID=MEDIATYPE.MEDIATYPEID
INNER JOIN CHINOOK.PLAYLIST
    ON MEDIATYPE.MEDIATYPEID=PLAYLIST.PLAYLISTID
INNER JOIN CHINOOK.PLAYLISTTRACK
    ON PLAYLIST.PLAYLISTID=PLAYLISTTRACK.PLAYLISTID
INNER JOIN CHINOOK.TRACK
    ON PLAYLISTTRACK.PLAYLISTID=TRACK.TRACKID;