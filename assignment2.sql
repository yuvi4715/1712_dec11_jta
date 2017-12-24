/*
Name: Stephen Oduor
Date: 12/20/2017
Assignment 2
Description: Performing various queries against the Oracle Chinook database
*/
--------------------------------------------------------------------------------
--2.1 SELECT
--SELECT ALL RECORDS FROM EMPLOYEE TABLE

Select * 
From Employee;
--------------------------------------------------------------------------------
--SELECT ALL RECORDS FROM THE EMPLOYEE TABLE WHERE LAST NAME IS KING
Select *
From Employee 
WHERE LastName = 'King';    
--------------------------------------------------------------------------------
--SELECT ALL RECORDS FROM EMPLOYEE TABLE WHERE FIRST NAME IS ANDREW AND
--AND REPORTSTO IS NULL
Select * 
From Employee
Where FirstName = 'Andrew' And ReportsTo Is Null;
--------------------------------------------------------------------------------
--2.2 ORDER BY

--SELECT ALL ALBUMS IN ALBUM AND SORT RESULT SET IN DESCENDING ORDER BY TITLE
--by title
Select * 
From Album
Order By Title desc;
--------------------------------------------------------------------------------
--SELECT FIRST NAME FROM CUSTOMER AND SORT RESULT SET IN ASCENDING ORDER BY CITY
--by city
Select FirstName, CITY
From Customer 
Order By City asc;
--------------------------------------------------------------------------------
--2.3 INSERT INTO

--INSERT TWO NEW RECORDS INTO GENRE TABLE
Insert Into
Genre(GenreId, Name)
Values(26, 'Crank');

Insert Into 
Genre(GenreId, Name)
Values(27, 'DubStep');
--------------------------------------------------------------------------------
--INSERT TWO NEW RECORDS INTO EMPLOYEE TABLE
INSERT INTO Employee 
(EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, 
            State, Country, PostalCode, Phone, Fax, Email) 
VALUES (9, 'Lee', 'Jack', 'Accountant', 1,
TO_DATE('1968-9-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
TO_DATE('2005-4-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '120 Cental Ave ',
'Buffalo', 'NY', 'United States', '12541', '+1 (683) 368-9884', '+1 (680) 488-4377', 
'jlee@gmine.com');

INSERT INTO Employee 
(EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, 
            State, Country, PostalCode, Phone, Fax, Email) 
VALUES (10, 'Thompson', 'Janette', 'Accountant', 1,
TO_DATE('1963-10-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
TO_DATE('2005-3-26 00:00:00','yyyy-mm-dd hh24:mi:ss'), '23 Sparrow Ave ',
'Ithaca', 'NY', 'United States', '12541', '+1 (453) 679-2384', '+1 (453) 478-9077', 
'jthompson@gmine.com');
--------------------------------------------------------------------------------
--INSERT TWO NEW RECORDS INTO CUSTOMER TABLE
Insert into Customer(CustomerId, FirstName, LastName, Company, Address, City,
                    State, Country, PostalCode, Phone, Fax, Email, SupportRepid)
Values(60, 'Alfred', 'Butler', 'Wayne Enterprise', '45 Cave Lane', 'Gotham', 'CA',
       'United States', '434323', '+1(434)-343-34333', '(432)-342-3412',
       'abutler@gmine.com',3);
       
Insert into Customer(CustomerId, FirstName, LastName, Company, Address, City,
                    State, Country, PostalCode, Phone, Fax, Email, SupportRepid)
Values(61, 'Clark', 'Bent', 'Luger Corp', '34 Smallville Rd', 'Metropolis', 'NY',
       'United States', '13323', '+1(134)-343-2335', '(123)-342-6533',
       'cbent@gmine.com',2);
--------------------------------------------------------------------------------
--2.4 UPDATE
--UPDATE AARON MITCHELL IN CUSTOMER TABLE TO ROBERT WALTER
UPDATE Customer
SET FirstName = 'Robert', LastName = 'Walter'
WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';
--------------------------------------------------------------------------------
--UPDATE NAME OF ARTIST IN THE ARTIST TABLE 'CREEDENCE CLEARWATER REVIVAL' TO
--'CCR'
Update Artist
Set Name = 'CCR'
Where Name = 'Creedence Clearwater Revival';
--------------------------------------------------------------------------------
--2.5 LIKE
--SELECT ALL INVOICES WITH A BILLING ADDRESS LIKE "T%"
Select *
From Invoice
Where BillingAddress Like 'T%';
--------------------------------------------------------------------------------
--2.6 BETWEEN
--SELECT ALL INVOICES THAT HAVE A TOTAL BETWEEN 15 and 50
Select *
From Invoice
Where Total Between 15 and 50;
--------------------------------------------------------------------------------
--2.7 DELETE
--DELETE A RECORD IN CUSTOMER TABLE WHERE THE NAME IS ROBERT WALTER
--(THERE MAY BE CONSTRAINTS THAT RELY ON THIS, FIND OUT HOW TO RESOLVE THEM)
DELETE 
FROM InvoiceLine
WHERE InvoiceId = 245 OR InvoiceId = 268 OR InvoiceId = 290 OR InvoiceId = 342
     OR InvoiceId = 50 OR InvoiceId = 61 OR InvoiceId = 116;

DELETE 
FROM Invoice
WHERE CustomerId = 32;

DELETE
FROM Customer
WHERE CustomerId = 32;
--------------------------------------------------------------------------------
-- 3.1 SYSTEM DEFINED FUNCTIONS
--CREATE A FUNCTION THAT RETURNS THE CURRENT TIME
Select CURRENT_TIMESTAMP 
FROM DUAL;
--------------------------------------------------------------------------------
--CREATE A FUNCTION THAT RETURNS THE LENGTH OF A MEDIATYPE FROM THE MEDIATYPE
--TABLE
Select Length('Mpeg audio file')
From dual;
--------------------------------------------------------------------------------
--3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS 

--CREATE A FUNCTION THAT RETURNS THE AVERAGE TOTAL OF ALL INVOICES
Select AVG(Total)
From Invoice;
--------------------------------------------------------------------------------
--CREATE A FUNCTION THAT RETURNS THE MOST EXPENSIVE TRACK
Select MAX(UnitPrice)
From Track;
--------------------------------------------------------------------------------
--3.3 User Defined Functions
--CREATE A FUNCTION THAT RETURNS THE AVERAGE PRICE OF INVOICELINE ITEMS IN THE 
--INVOICELINE TABLE
CREATE OR REPLACE FUNCTION avgPrice
RETURN NUMBER AS
     average_a NUMBER;
BEGIN
    SELECT AVG(UnitPrice)INTO average_a
    FROM InvoiceLine;
    
RETURN average_a;
End avgPrice;
/

SELECT avgPrice()
FROM Dual;
--------------------------------------------------------------------------------
--3.4 USER DEFINED TABLE VALUED FUNCTIONS
--CREATE A FUNCTION THAT RETURNS ALL EMPLOYEES BORN AFTER 1968

CREATE OR REPLACE TYPE Employee_Obj AS OBJECT(
LastName VARCHAR2(20),
FirstName VARCHAR2(20))
/


CREATE OR REPLACE TYPE EmpObjColl AS TABLE OF Employee_Obj;
/

CREATE OR REPLACE FUNCTION afterSixtyEight
RETURN EmpObjColl 
AS
vEmpObjColl EmpObjColl;

BEGIN
    
SELECT Employee_Obj( A.LastName, A.FirstName)
    BULK COLLECT INTO vEmpObjColl
    FROM(SELECT * 
            FROM Employee 
            WHERE BirthDate > TO_DATE('1968-12-31 00:00:00','yyyy-mm-dd hh24:mi:ss'))A;
    RETURN vEmpObjColl;
END;
/

SELECT *
FROM TABLE(afterSixtyEight);


--------------------------------------------------------------------------------
--4.1 BASIC STORED PROCEDURE
--CREATE A STORED PROCEDURE THAT SELECTS THE FIRST AND LAST NAMES OF ALL EMPLOYEES

CREATE OR REPLACE PROCEDURE getEmployeeName AS
CURSOR c_employee IS 
        SELECT FirstName, LastName
        FROM Employee;
BEGIN
    FOR emp IN c_employee
         LOOP
            dbms_output.put_line(emp.FirstName || ' ' || emp.LastName);
         END LOOP;
END getEmployeeName;
/

EXECUTE getEmployeeName;
--------------------------------------------------------------------------------

--4.2 STORED PROCEDURE INPUT PARAMETERS

--CREATE A STORED PROCEDURE THAT UPDATES THE PERSONAL INFORMAION OF AN EMPLOYEE

CREATE OR REPLACE PROCEDURE updateEmployee(
pEmployeeId Employee.EmployeeId%TYPE, 
pLastName Employee.LastName%TYPE,
pFirstName Employee.FirstName%TYPE, 
pTitle Employee.Title%TYPE,
pReportsTo Employee.ReportsTo%TYPE,
pBirthDate Employee.BirthDate%TYPE,
pHireDate Employee.HireDate%TYPE, 
pAddress Employee.Address%TYPE,
pCity Employee.City%TYPE, 
pState Employee.State%TYPE,
pCountry Employee.Country%TYPE,
pPostalCode Employee.PostalCode%TYPE, 
pPhone Employee.Phone%TYPE, 
pFax Employee.Fax%TYPE,
pEmail Employee.Email%TYPE)
AS
    BEGIN
        UPDATE Employee
        SET EmployeeId = pEmployeeId, LastName = pLastName, FirstName = pFirstName,
            Title = pTitle, ReportsTo = pReportsTo, BirthDate = pBirthDate,
            HireDate = pHireDate, Address = pAddress, City = pCity, State = pState,
            Country = pCountry, PostalCode = pPostalCode, Phone = pPhone, Fax = pFax,
            Email = pEmail
        WHERE EmployeeId = pEmployeeId;
END updateEmployee;
/

--Updating everything except employeeId
EXECUTE updateEmployee (8, 'Thompson', 'Morris', 'Accountant', 1,TO_DATE('1963-10-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2005-3-26 00:00:00','yyyy-mm-dd hh24:mi:ss'), '23 Sparrow Ave ','Ithaca', 'NY', 'United States', '12541', '+1 (453) 679-2384', '+1 (453) 478-9077', 'jthompson@gmine.com');

Select * 
From Employee
Where EMPLOYEEID = 8;

--CREATE A STORED PROCEDURE THAT RETURNS THE MANAGERS OF AN EMPLOYEE
CREATE PROCEDURE getEmpManager(empId IN NUMBER) AS
BEGIN
    SELECT ReportsTO
    FROM Employee
    WHERE EmployeeId = empId;
    
END getEmpManager;
/
EXECUTE getEmpManager(4);
--------------------------------------------------------------------------------
--4.3 STORED PROCEDURED OUTPUT PARAMETERS
--CREATE A STORED PROCEDURE THAT RETURNS THE NAME AND COMPANY OF A CUSTOMER

CREATE OR REPLACE PROCEDURE customerInfo(
pCustomerId IN CUSTOMER.CUSTOMERID%TYPE,
cus_cursor IN OUT SYS_REFCURSOR)
AS
    BEGIN
    OPEN cus_cursor
    FOR
        SELECT FirstName, LastName, Company
        FROM Customer
        Where CustomerId = pCustomerId;
END;
/
    
DECLARE
    vFirstName CUSTOMER.FirstName%TYPE;
    vLastName CUSTOMER.LastName%TYPE;
    vCompany CUSTOMER.Company%TYPE;
    cus_refcur SYS_REFCURSOR;
BEGIN
    customerInfo(4, cus_refcur);
    LOOP
        FETCH cus_refcur INTO vFirstName, vLastName, vCompany;
        EXIT WHEN cus_refcur % NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(vFirstName ||' ' || vLastName ||' '||vCompany );
    END LOOP;
  CLOSE cus_refcur;
END;

    
--------------------------------------------------------------------------------
--5.0 TRANSACTIONS
--CREATE A TRANSACTION THAT GIVEN A INVOICEID WILL DELETE THAT INVOICE 
--(THERE MAY BE CONSTRAINTS THAT RELY ON THIS, FIND OUT HOW TO RESOLVE THEM)

CREATE OR REPLACE PROCEDURE deleteInvoice(invoiceId_p IN INVOICE.INVOICEID%TYPE)
AS
    BEGIN
    --Deleting child table fist to resolve conficts
        DELETE 
        FROM InvoiceLine
        WHERE InvoiceId = invoiceId_p;
    
        DELETE 
        FROM Invoice
        WHERE invoiceId_p = invoiceId;
END;
/

EXECUTE deleteInvoice(213);
--------------------------------------------------------------------------------

--CREATE A TRANSACTION NESTED WITHIN A STORED PROCEDURE THAT INSERTS A NEW RECORD
--IN THE CUSTOMER TABLE

CREATE OR REPLACE PROCEDURE insertNewRecordInCustomer(
CustomerId IN CUSTOMER.CUSTOMERID%TYPE,
FirstName IN CUSTOMER.FIRSTNAME%TYPE, 
LastName IN CUSTOMER.LASTNAME%TYPE, 
Company IN CUSTOMER.COMPANY%TYPE,
Address IN CUSTOMER.ADDRESS%TYPE,
City IN CUSTOMER.CITY%TYPE, 
State IN CUSTOMER.STATE%TYPE, 
Country IN CUSTOMER.COUNTRY%TYPE,
PostalCode IN CUSTOMER.POSTALCODE%TYPE,
Phone IN CUSTOMER.PHONE%TYPE, 
Fax IN CUSTOMER.FAX%TYPE, 
Email IN CUSTOMER.EMAIL%TYPE, 
SupportRepid IN CUSTOMER.SUPPORTREPID%TYPE)
AS
BEGIN
    INSERT INTO Customer(CustomerId, FirstName, LastName, Company, Address, City,
                    State, Country, PostalCode, Phone, Fax, Email, SupportRepid)
    VALUES(CustomerId, FirstName, LastName, Company, Address, City,
                    State, Country, PostalCode, Phone, Fax, Email, SupportRepid);
END;
/


--EXECUTE insertNewRecordInCustomer(63, 'Alexis', 'Ozil', 'Chelsea', '34 Smallville Rd', 'Metropolis', 'NY', 'United States', '13323', '+1(134)-343-2335', '(123)-342-6533','cbent@gmine.com',2);

--SELECT * FROM CUSTOMER;
--------------------------------------------------------------------------------
--6.0 TRIGGERS
--CREATE AN INSERT TRIGGER ON THE EMPLOYEE TABLE FIRED AFTER A NEW RECORD IS 
--INSERTED INTO THE TABLE

CREATE OR REPLACE TRIGGER empInsertTrigger AFTER INSERT ON Employee
    BEGIN 
        DBMS_OUTPUT.PUT_LINE('Insert on Employee table succesful, modified on: '|| SYSTIMESTAMP);
END;
/
/*
INSERT INTO Employee 
(EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, 
            State, Country, PostalCode, Phone, Fax, Email) 
VALUES (32, 'Thompson', 'John', 'Accountant', 1,
TO_DATE('1963-10-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
TO_DATE('2005-3-26 00:00:00','yyyy-mm-dd hh24:mi:ss'), '23 Sparrow Ave ',
'Ithaca', 'NY', 'United States', '12541', '+1 (453) 679-2384', '+1 (453) 478-9077', 
'jthompson@gmine.com');*/
--------------------------------------------------------------------------------
--CREATE AN AFTER UPDATE TRIGGER ON THE ALBUM TABLE AFTER A NEW RECORD IS 
--INSERTED INTO THE TABLE

CREATE OR REPLACE TRIGGER albInsertTrigger AFTER INSERT ON ALBUM
    BEGIN 
        DBMS_OUTPUT.PUT_LINE('Insert on Album table succesful, modified on: '|| SYSTIMESTAMP);
END;
/
--------------------------------------------------------------------------------
--CREATE AN AFTER DELETE TRIGGER ON THE CUSTOMER TABLE THAT FIRES AFTER A ROW IS
--DELETED FROM THE TABLE

CREATE OR REPLACE TRIGGER cusDeleteTrigger AFTER INSERT ON ALBUM
    BEGIN 
        DBMS_OUTPUT.PUT_LINE('Delete on Customer table succesful, modified on: '|| SYSTIMESTAMP);
END;
/
--------------------------------------------------------------------------------
--7.1 INNER JOIN
--CREATE AN INNER JOIN THAT JOINS CUSTOMERS AND ORDERS AND SPECIFIES THE NAME OF
--THE CUSTOMERS

SELECT CUSTOMER.FirstName, CUSTOMER.LastName
FROM CUSTOMER
INNER JOIN Invoice
ON CUSTOMER.customerId = INVOICE.customerId ;
-------------------------------------------------------------------------------
--7.2 INNER
--CREATE AN OUTER JOIN THAT JOINS THE CUSTOMER AND INVOICE TABLE, SPECIFYING
--THE CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID AND TOTAL

SELECT CUSTOMER.FirstName, CUSTOMER.LastName, INVOICE.InvoiceId, INVOICE.Total
FROM CUSTOMER
FULL OUTER JOIN INVOICE 
ON CUSTOMER.CustomerId = INVOICE.customerId;
--------------------------------------------------------------------------------
--7.3 RIGHT
--CREATE A RIGHT JOIN THAT JOINS ALBUM AND ARTIST SPECIFYING ARTIST NAME AND 
--TITLE

SELECT ARTIST.Name, ALBUM.Title
FROM ALBUM
RIGHT JOIN ARTIST
ON  ALBUM.ArtistId = ARTIST.ArtistId;
--------------------------------------------------------------------------------
--7.4 CROSS
--CREATE A CROSS JOIN THAT JOINS ALBUM AND ARTIST AND SORTS BY ARTIST NAME
--IN ASCENDING ORDER

SELECT ARTIST.Name, ALBUM.AlbumId, ALBUM.Title
FROM ALBUM CROSS JOIN ARTIST
ORDER BY ARTIST.Name DESC;
--------------------------------------------------------------------------------
--7.5 SELF
--PERFORM A SELF_JOIN ON THE EMPLOYEE TABLE, JOINING ON THE REPORTSTO COLUMN

SELECT A.EmployeeId AS "EmployeeId", A.FirstName AS "Emp First Name", A.LastName AS "Emp Last Name", 
       B.EmployeeId AS "SupervisorId", B.FirstName AS "Sup First Name", B.LastName AS "Sup Last Name"
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.ReportsTO = B.EmployeeId;
--------------------------------------------------------------------------------
--7.6 COMPLICATED JOIN ASSIGNMENT
--CREATE AN INNER JOIN BETWEEN ALL TABLES IN THE CHINOOK DATABASE
SELECT
    EMPLOYEE.EmployeeId ,EMPLOYEE.FirstName, EMPLOYEE.LastName,
    CUSTOMER.CustomerId, CUSTOMER.FirstName, CUSTOMER.LastName,
    INVOICE.InvoiceId, INVOICE.CUSTOMERID,
    INVOICELINE.InvoiceLineId, INVOICELINE.InvoiceId,
    TRACK.TrackId, TRACK.Name,
    GENRE.Name AS "GENRE",
    MEDIATYPE.NAME AS "MEDIA TYPE",
    PLAYLIST.Name AS "PlayList Name",
    ALBUM.AlbumId, ALBUM.Title,
    ARTIST.ArtistId, ARTIST.NAME AS "ARTIST NAME"
FROM
    EMPLOYEE
INNER JOIN 
    CUSTOMER ON CUSTOMER.SupportRepId = EMPLOYEE.EmployeeId
INNER JOIN
    INVOICE ON CUSTOMER.CustomerId = INVOICE.CustomerId
INNER JOIN
    INVOICELINE ON INVOICE.InvoiceId = INVOICELINE.InvoiceId
INNER JOIN
    TRACK ON INVOICELINE.TrackId = TRACK.TrackId
INNER JOIN
    GENRE ON TRACK.GenreId = GENRE.GenreId
INNER JOIN
    MEDIATYPE ON TRACK.MediaTypeId = MEDIATYPE.MediaTypeId
INNER JOIN
    PLAYLISTTRACK ON TRACK.TrackId = PLAYLISTTRACK.TrackId
INNER JOIN
    PLAYLIST ON PLAYLISTTRACK.PlayListId = PLAYLIST.PlayListId
INNER JOIN
    ALBUM ON TRACK.AlbumId = ALBUM.AlbumId
INNER JOIN
    ARTIST ON ALBUM.ArtistId = ARTIST.ArtistId;
--------------------------------------------------------------------------------






































