-- Maurice Jagan Chinook SQL File --

SELECT * FROM Employee;

SELECT * FROM Employee
WHERE LASTNAME = 'King';

SELECT * FROM Employee
WHERE FirstName = 'Andre' 
AND Reportsto = NULL;

SELECT * FROM Album
ORDER BY Title DESC;

SELECT FirstName, City FROM Customer
ORDER BY City ASC;

--inserts two new genres

INSERT INTO Genre (GENREID, NAME)
VALUES (184,'Punk');

INSERT INTO Genre (GENREID, NAME)
VALUES (283, 'RAGA');

--inserts two employees

INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES (123, 'Rosencrantz', 'Joey');

INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES (124, 'Bravo', 'Johnny');

--insert two customers:

INSERT INTO Customer (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES (125, 'Bringahnd', 'Jared', 'whatever@somedomain.com');

INSERT INTO Customer (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES (127, 'Specktor', 'Regina', 'swift@thegreatestdomain.com');


--update customer

UPDATE Customer
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--update customer

UPDATE Artist
SET Name = 'CCR'
WHERE Name = 'Creedence Clearwater Revival';

--2.5

SELECT *
FROM Invoice
WHERE BillingAddress LIKE 'T%';

--2.6

SELECT *
FROM Invoice
WHERE TOTAL BETWEEN 15 AND 50;

SELECT *
FROM Employee
WHERE HIREDATE BETWEEN '1 June 2003' AND '1 Mar 2004';

--2.7

--retreive the customer ID with select, then delete all of the children going up the chain.

SELECT * FROM Customer  --no customer with the lastname walter (as asked for in the assignment); closest match Robert Brown.
WHERE LastName = 'Walter';

SELECT * FROM INVOICE 
WHERE Customerid = '29';


DELETE FROM Invoiceline
WHERE Invoiceid = '235';  

DELETE FROM Invoiceline
WHERE Invoiceid = '364';

DELETE FROM Invoiceline
WHERE Invoiceid = '387';

DELETE FROM Invoiceline
WHERE Invoiceid = '409';

DELETE FROM Invoiceline
WHERE Invoiceid = '48';

DELETE FROM Invoiceline
WHERE Invoiceid = '169';

DELETE FROM Invoiceline
WHERE Invoiceid = '180';


DELETE FROM Invoice
WHERE Customerid = '29';

DELETE FROM Customer
WHERE FirstName = 'Robert' AND LastName = 'Brown';






--3.1

create or replace FUNCTION TIME RETURN VARCHAR2 AS 

the_time varchar2(40);

BEGIN
SELECT to_char(CURRENT_DATE, 'DD-MON-YYYY HH:MI:SS')
    into the_time
    FROM dual;
    
    RETURN the_time;
END TIME;

SELECT TIME from dual; 


create or replace FUNCTION LENGTHOF(theName varchar2) 
RETURN VARCHAR2 AS 
the_length varchar2(40);
thevariable varchar2(40);

BEGIN
SELECT m.NAME into thevariable from chinook.MEDIATYPE m
    where m.NAME = theName;
    the_length := LENGTH(thevariable);
    RETURN the_length;
END LENGTHOF;

SELECT LENGTHOF(MEDIATYPE.NAME) from dual;

--3.2

create or replace FUNCTION THEAVG 
RETURN NUMBER AS 
Average Number(38);

BEGIN
    select AVG(i.TOTAL) into Average from INVOICE i
        --group by (i.customerid)
        order by i.customerid;
  RETURN Average;
END THEAVG;

SELECT THEAVG from dual;



create or replace FUNCTION THEMAX 
RETURN NUMBER AS 
Maxprice Number(38);

BEGIN
    select MAX(i.UNITPRICE) into Maxprice from INVOICELINE i
        --group by (i.invoicelineid)
        order by i.invoicelineid;
  RETURN Maxprice;
END THEMAX;

SELECT THEMAX from dual;

--3.3

create or replace FUNCTION INVAVG 
RETURN NUMBER AS 
AveragePrice Number(38);

BEGIN
    select AVG(i.UNITPRICE) into AveragePrice from INVOICELINE i
        --group by (i.customerid)
        order by i.INVOICELINEID;
  RETURN AveragePrice;
END INVAVG;

SELECT INVAVG from dual;

--3.4

create or replace FUNCTION BORN 
RETURN VARCHAR2 AS 
--the_length varchar2(40);
thevariable varchar2(40);

BEGIN
--e.LASTNAME 
for x in(SELECT e.FIRSTNAME into thevariable from EMPLOYEE e where e.BIRTHDATE > '1 January 1968')
loop
    RETURN thevariable;
end loop;
END BORN;

SELECT BORN from dual;

--4.1 Stored proceedures

Create Procedure RetreiveEmp
AS
BEGIN

Select FIRSTNAME, LASTNAME from EMPLOYEE;

END;

Execute RetreiveEmp;


--4.2 with parameters

Create Procedure UpdateEmp 
@firstname varchar2
@lastname varchar2
AS
BEGIN

UPDATE EMPLOYEE
SET ADDRESS = '21 North Windale dr.', CITY = 'Windsor', STATE = 'CT'
WHERE LASTNAME = @lastname and FIRSTNAME = @firstname;

END;

Execute UpdateEmp 'King', 'Walter';

Create Procedure ReturnEmp
@firstname varchar2
AS
BEGIN

Select REPORTSTO
FROM EMPLOYEE
Where FIRSTNAME = @firstname;

END;


Execute ReturnEmp 'Walter';

--4.3 output

Create Procedure CustInfo
@customerid varchar2
AS
BEGIN

SELECT FIRSTNAME, LASTNAME, COMPANY
FROM Customer
WHERE CUSTOMERID = @customerid;

END;

Execute CustInfo '234';

--5.0 Transactions

Create Procedure DelInvoice
@invoiceid varchar2
AS
BEGIN

DELETE
FROM INVOICE
WHERE INVOICEID = @invoiceid;

END;

Execute DelInvoice '1234';


Create Procedure CreateCustomer
AS
BEGIN

INSERT INTO Customer (CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES (1260, 'Smith', 'Aaron', 'sss@gmaildomain.com');

END;

Execute CreateCustomer;


--6.1 AFTER FOR

Create Trigger tr_employeeinsert_AfterInsert
ON EMPLOYEE
FOR INSERT
AS
BEGIN

SELECT * FROM inserted

END;


Create Trigger tr_albumupdate_AfterUpdate
ON ALBUM
FOR UPDATE
AS
BEGIN

SELECT * FROM updated

END;


Create Trigger tr_customerdelete_AfterDelete
ON CUSTOMER
FOR DELETE
AS
BEGIN

SELECT * FROM deleted

END;


--JOINS
--7.1 inner join

SELECT c.FIRSTNAME, c.LASTNAME, i.INVOICEID
FROM Customer c 
INNER JOIN Invoice i ON c.CUSTOMERID = i.CUSTOMERID;

--7.2 outter join

SELECT c.CUSTOMERID, c.FIRSTNAME, c.LASTNAME, i.INVOICEID, i.TOTAL
FROM Customer c 
LEFT OUTER JOIN Invoice i ON c.CUSTOMERID = i.CUSTOMERID;

--7.3 right

SELECT a.NAME, b.TITLE
FROM Artist a
RIGHT JOIN Album b ON a.ARTISTID = b.ARTISTID;

--7.4 CROSS

SELECT a.NAME,a.ARTISTID, b.ALBUMID, b.ARTISTID, b.TITLE
FROM Artist a
CROSS JOIN Album b --ON a.ARTISTID = b.ARTISTID
ORDER BY a.NAME ASC;

--7.5 SELF

SELECT *
FROM EMPLOYEE e, EMPLOYEE f
WHERE e.REPORTSTO = f.REPORTSTO;

--7.6 Complicated Join Assignment

SELECT * --c.FIRSTNAME, c.LASTNAME, i.INVOICEID
FROM Album a --, Artist b, Customer c, Employee e, Genre g, Invoice i, Invoiceline il, Mediatype m, Playlist p, PlaylistTrack pt, Track t 
INNER JOIN Employee e 
ON e.EMPLOYEEID = c.SUPPORTREPID;
INNER JOIN Customer c 
ON c.CUSTOMERID = i.CUSTOMERID;
INNER JOIN Track t 
ON t.GENREID = g.GENREID;
INNER JOIN Genre g 
ON g.GENREID = t.GENREID;
INNER JOIN Artist b 
ON a.ARTISTID = b.ARTISTID;
INNER JOIN Album a 
ON a.ARTISTID = b.ARTISTID;
INNER JOIN Invoice i 
ON i.INVOICEID = il.INVOICEID;
INNER JOIN Invoiceline il 
ON i.INVOICEID = il.INVOICEID;
INNER JOIN Mediatype m 
ON m.MEDIATYPEID = t.MEDIATYPEID;
INNER JOIN Playlist p 
ON p.PLAYLISTID = pt.PLAYLISTID;
INNER JOIN Playlisttrack pt 
ON pt.PLAYLISTID = p.PLAYLISTID;


--9.0

BACKUP DATABASE chinook TO DISK='C:\Revature\SQL\chinook.bak'

