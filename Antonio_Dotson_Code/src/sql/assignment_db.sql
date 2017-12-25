/* ANTONIO DOTSON HOME WORK ASSIGNMENT */

--2.1 SELECT-
select * from Employee;
/
select * from  Employee where LASTNAME like 'King' order by LASTNAME;
/
select * from Employee where FIRSTNAME = 'Andrew' or 'REPORTSTOR' is null;
/
---Order by---
select * from Album order by TITLE desc;
/
select * from CUSTOMER order by City asc;
/
---Insert ------
/*SELECT * FROM GENRE;*/
insert into GENRE VALUES (26,'New Wave');
insert into GENRE VALUES (27,'Classic Rap');
/
INSERT INTO EMPLOYEE VALUES('9','DOTSON','ANTONIO','MANAGER',NULL,'17-MAY-93','18-MAR-01','22722 CARTERMOIR','KATY','TX','US','77449','8325760651',NULL,'ANTONIOMDOTSON@GMAIL.COM');
INSERT INTO EMPLOYEE VALUES('10','DOTSON','CARLOS','SUPERVISOR',NULL,'17-MAR93','18-FEB-01','22722 CARTERMOIR','KATY','TX','US','77449','8325760651',NULL,'ANTONIOMDOTSON@GMAIL.COM');
/
INSERT INTO CUSTOMER VALUES('60','DOTSON','ANTONIO','REVATURE','22722 CARTER MOIR','KATY','TX','US','77449','2816325888','NULL','amdotson@gmail.com',null);
INSERT INTO CUSTOMER VALUES('61','DOTSON','CARLOS','REVATURE','22722 CARTER MOIR','KATY','TX','US','77449','2816325888','NULL','carlos@gmail.com',null);
/
----update-------
UPDATE CUSTOMER SET FIRSTNAME ='ROBERT',LASTNAME ='WALTER' WHERE FIRSTNAME='Aaron' and LASTNAME ='Mitchell';
UPDATE ARTIST SET NAME ='CCR' WHERE NAME = 'Creedence Clearwater Reviva';
/
----like between date-----
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%'; 
/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50 ORDER BY TOTAL DESC;
/
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN  TO_DATE('01-JUN-2003','DD-MON-YYYY') AND TO_DATE('01-MAR-2004','DD-MON-YYYY') ORDER BY HIREDATE DESC;
/
DELETE FROM CUSTOMER WHERE FIRSTNAME ='ROBERT' AND LASTNAME ='WALTER';
/
----create procedures ---------
create or replace function getDate
return date is

  l_sysdate date;

begin

  select sysdate
    into getDate
    from dual;

  return l_sysdate;

end;
/
 create or replace function findlength(pid Number)
return number
as anotherVariable number;
playerName varchar(30);

begin
select p.NAME into playerName from Mediatype p where p.MEDIATYPEID = pid;
    anotherVariable := length(playerName);
    return anotherVariable;
end;
/

create or replace function averageTotalInv
return number
as totalinvoice number;
begin
select round(avg(p.Total)) into totalinvoice from INVOICE P;
return totalinvoice;
end;
 /
create or replace function MaxUnitPrice
return number
as maxunit number;
begin
select max(p.unitprice) into maxunit from track p;
return maxunit;
end;
/
--CURSOR RETURN FROM FUNCTION-----

CREATE OR REPLACE FUNCTION findemployees RETURN SYS_REFCURSOR

IS 

EMPLOYEE_CURSOR SYS_REFCURSOR;

BEGIN

    OPEN EMPLOYEE_CURSOR  FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE > to_date(1968,'YYYY');

    RETURN EMPLOYEE_CURSOR;

END;
--cursor as a pass by reference---
/*4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.*/

CREATE OR REPLACE PROCEDURE EMPLOYEE_NAMES(MY_CURSOR OUT SYS_REFCURSOR)

AS

BEGIN

    OPEN MY_CURSOR FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;

END;

/


set serveroutput on;

DECLARE

    MY_CURSOR SYS_REFCURSOR;

    FIRST_NAME VARCHAR2(30);

    LAST_NAME VARCHAR2(30);

BEGIN

    EMPLOYEE_NAMES(MY_CURSOR);

    LOOP

        FETCH MY_CURSOR INTO FIRST_NAME, LAST_NAME;

        EXIT WHEN MY_CURSOR%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(UPPER(LAST_NAME)|| ',' || UPPER(FIRST_NAME));

    END LOOP;

END;

/
/*Task – Create a stored procedure that returns the name and company of a customer.*/
CREATE OR REPLACE PROCEDURE FINDCUSTOMERINFO(CUSID NUMBER)
AS 
S_NAME VARCHAR(50);
S_COMPANY VARCHAR(50);
BEGIN
SELECT CONCAT(CONCAT(LASTNAME,' '),FIRSTNAME) AS NAME, COMPANY INTO S_NAME, S_COMPANY FROM 
CUSTOMER WHERE CUSTOMERID = CUSID;
        DBMS_OUTPUT.PUT_LINE(UPPER(S_NAME)|| ' - ' || UPPER(S_COMPANY));
END FINDCUSTOMERINFO;

EXEC FINDCUSTOMERINFO(5)
/
set serveroutput on;
/*--Task – Create a stored procedure that returns the managers of an employee.*/
CREATE OR REPLACE PROCEDURE GET_MANAGER(EMPID NUMBER)
AS
MANAGER_NAME VARCHAR2(25);
BEGIN
SELECT CONCAT(CONCAT(LASTNAME,' '),FIRSTNAME) INTO MANAGER_NAME FROM EMPLOYEE
WHERE EMPLOYEEID = (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = EMPID);
 DBMS_OUTPUT.PUT_LINE(MANAGER_NAME);
END GET_MANAGER;
/
EXEC GET_MANAGER(3);
/*5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored
procedure.*/

/*Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
rely on this, find out how to resolve them).*/
--Begin the transaction
SET TRANSACTION READ WRITE;
--Point the time log rows in project_hours to the new project number
DELETE FROM INVOICELINE WHERE INVOICEID = 5;
SAVEPOINT APT100012;
DELETE FROM INVOICE WHERE INVOICEID = 5;
SAVEPOINT APT100013;
COMMIT;
/
ROLLBACK APT100012;
/
ROLLBACK APT100013;
/

Create sequence THE_SEQ

	minvalue 1

	maxvalue 1000

	start with 1

	increment by 1;


/

/*Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
table*/
CREATE OR REPLACE PROCEDURE INSERTRECORD (
   customerid IN NUMBER,
   firstname  IN VARCHAR2,
   lastname   IN VARCHAR2,
   company    IN VARCHAR2,
   address    IN VARCHAR2,
   city       IN VARCHAR2,
   state      IN VARCHAR2,
   country    IN VARCHAR2,
   POSTALCODE IN VARCHAR2,
   PHONE      IN VARCHAR2,
   FAX        IN VARCHAR2,
   EMAIL      IN VARCHAR2,
   SUPPORTREPID IN NUMBER 
   ) AS
BEGIN
  /* SELECT the_seq.NEXTVAL INTO CUSTOMERID FROM dual;*/
   INSERT INTO CUSTOMER VALUES (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email,supportrepid);
commit;
SAVEPOINT APT00003;
end InsertRecord;
/
EXEC INSERTRECORD(60,'Rick','Morty','Some Company','1 circle','houston','tx','us','77777','832-576-0651','999-999-9999','email@email.com',2);
/
ROLLBACK;
/
--Task – Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE UPDATE_CUSTOMER(P_ADDRESS VARCHAR2,P_CITY VARCHAR2,P_STATE VARCHAR2,P_PHONE VARCHAR2,p_FAX VARCHAR2,P_EMAIL VARCHAR2)
AS
EMID NUMBER := 8;
BEGIN

 UPDATE EMPLOYEE SET ADDRESS = P_ADDRESS, CITY = p_CITY,STATE = p_STATE, PHONE = P_PHONE, FAX = P_FAX, EMAIL = P_EMAIL
 WHERE EMPLOYEEID = EMID; 
 COMMIT;
 SAVEPOINT XYZ0001;
END UPDATE_CUSTOMER;
  /
EXEC UPDATE_CUSTOMER('101 SUGAR CIRCLE','HOUSTON','TX','832-999-9999','999-99-9999','AMDOTSON@GMAIL.COM');
/
/* 6-0 */
/*Task - Create an after insert trigger on the employee table fired after a new record is inserted into the
table.*/
create or replace trigger insert_employee
after insert on EMPLOYEE for each row
begin
       DBMS_OUTPUT.PUT_LINE('Inserting');
end;
/

/*Task – Create an after update trigger on the album table that fires after a row is inserted in the table*/
create or replace trigger update_album
after update on Album for each row
begin
       DBMS_OUTPUT.PUT_LINE('Inserting new Album');
end;
/
/*Task – Create an after delete trigger on the customer table that fires after a row is deleted from the
table.8*/
create or replace trigger delete_customer
after delete on Customer for each row
begin
       DBMS_OUTPUT.PUT_LINE('Deleting Customer');
end;
/
/*7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and
the invoiceId.*/
select concat(a.lastname, a.firstname) as name, c.invoiceid from customer a join invoice c on a.customerid = c.customerid order by name;
/
/*
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
firstname, lastname, invoiceId, and total.*/
select a.customerid,a.firstname,a.lastname,c.invoiceid, c.total from customer a left join invoice c on a.customerid = c.customerid order by a.lastname;
/
/* 
7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/
select a.title, b.name from album a right join artist b on a.artistid = b.artistid;
/
/*
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/
select title, name from album cross join artist where artist.ARTISTID = album.ARTISTID order by name asc;
/
/*
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*/
select e.employeeid,e.lastname,e.firstname,e.title,e.birthdate,e.hiredate,e.address,e.city,e.state,e.country,e.postalcode,e.phone,e.fax,e.email
from employee e join employee c on c.REPORTSTO = e.reportsto;
/
/*
7.6 Complicated Join assignment
*/
select * from ALBUM al
join Artist a on al.ARTISTID = a.ARTISTID
join TRACK t on al.ALBUMID = t.ALBUMID 
join PLAYLISTTRACK p on p.TrackID = t.trackid join
PLAYLIST pl on pl.playlistid = p.playlistid join MEDIATYPE m on m.mediatypeid = t.MEDIATYPEID join
GENRE g on g.GENREID = t.GENREID join INVOICELINE iv on iv.TRACKID = t.TRACKID join invoice i on i.INVOICEID = iv.INVOICEID left join CUSTOMER c
on c.customerid = i.CUSTOMERID join employee e on c.SUPPORTREPID = e.EMPLOYEEID;
/*
/*9.0 Administration
In this section you will be creating backup files of your database. After you create the backup file you
will also restore the database.
Task – Create a .bak file for the Chinook database--- UNABLE TO CREATE BACK UP, TRIED TO GET BIN/SH TO WORK BUT IT WOULD NOT FIND
MY DIRECTORY TO EXECUTE SQL FROM THE COMMAND LINE TO CREATE A WORKSPACE AND BACK UP THE DATABASE LOCALLY*/