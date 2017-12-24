------------------------ 2.0 SQL Queries ------------------------

---------- 2.1 SELECT ----------
SELECT * FROM Employee;
-- Selected all records from the Employee table.

SELECT * FROM Employee WHERE LastName = 'King';
-- Selected all records from the Employee table where the LastName = 'King'

SELECT * FROM Employee WHERE FirstName = 'Andrew' AND ReportsTo IS NULL;
-- Selected all records from the Employee table where the FirstName = 'Andrew' and ReportsTo is null



---------- 2.2 ORDER BY ----------
SELECT * FROM Album ORDER BY Title DESC;
-- Selected all albums in Album table and sort result set in descending order by title.

SELECT FirstName FROM Customer ORDER BY City ASC;
-- Selected first name from Customer and sort result set in ascending order by city



---------- 2.3 INSERT INTO ----------
INSERT INTO Genre VALUES (26, 'Punk Rock');
INSERT INTO Genre VALUES (27, 'Pop Punk');
-- Inserted Genres 26 (Punk Rock) & 27 (Pop Punk)

--INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (8, 'Callahan', 'Laura', 'IT Staff', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'laura@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Fernandez', 'Joseph', 'JTA Developer', 4, TO_DATE('1994-07-06 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), TO_DATE('2017-12-11 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), '6307 Briar Canyon Ct', 'Katy', 'TX', 'USA', '77450', '8328754627', '8328754627', 'Joseph.RP.Fernandez@gmail.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Mughrabi', 'Mohammad',  'Mechanical Engineer', 4, TO_DATE('1990-02-21', 'yyyy-mm-dd'), TO_DATE('2017-12-20', 'yyyy-mm-dd'), '6303 Briar Canyon Ct.', 'Katy', 'TX', 'USA', '77450', '8324345987', '8324345987', 'Mohammad9271@gmail.com');
-- Inserted Employee 9 (Joseph Fernandez) & 10 (Mohammad Mughrabi)

--INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (4, 'BjÃ¸rn', 'Hansen', 'UllevÃ¥lsveien 14', 'Oslo', 'Norway', '0171', '+47 22 44 22 22', 'bjorn.hansen@yahoo.no', 4);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'Brandon', 'Widow', '9251 S Fry Rd', 'TX', 'USA', '77450', '832-638-1404', 'BrandonWidow@gmail.com', 2);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Anu', 'Parasher', '4800 Calhoun Rd', 'TX', 'USA', '77004', '713-360-8226', 'anu.parasher@hotmail.com', 2);
-- Inserted Customer 60 (Brandon Widow) & 61 (Anu Parasher)



---------- 2.4 UPDATE ----------
UPDATE Customer SET FirstName = 'Robert', LastName = 'Walker' WHERE FirstName = 'Aaron';
-- Updated the FirstName and LastName of 'Aaron Mitchell' to 'Robert Walker'. Everything else in the table remained the same.

UPDATE Artist SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
-- Updated the Name of the music group 'Creedence Clearwater Revival' to 'CCR'



---------- 2.5 LIKE ----------
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';
-- Selected all invoices with a billing address like “T%”



---------- 2.6 BETWEEN ----------
SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;
-- Selected all invoices that have a total between 15 and 50

--SELECT * FROM Employee WHERE HireDate BETWEEN TO_DATE('2003-06-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-03-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss');
SELECT * FROM Employee WHERE HireDate BETWEEN Date '2003-06-01' AND Date '2004-03-01';
-- Selected all employees hired between 1st of June 2003 and 1st of March 2004



---------- 2.7 DELETE ----------
--ALTER TABLE Invoice ADD CONSTRAINT FK_INVOICECUSTOMERID FOREIGN KEY (CustomerID) REFERENCES Customer (CustomerID);
ALTER TABLE Invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;                           -- to Drop Constraint in Invoice Table
ALTER TABLE Invoice ADD CONSTRAINT FK_INVOICECUSTOMERID_Cascade                     -- to Add Cascade Constraint in Invoice Table
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE CASCADE;

ALTER TABLE InvoiceLine DROP CONSTRAINT FK_INVOICELINEINVOICEID;                    -- to Drop Constraint in InvoiceLine Table
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_IVLINVOICEID_Cascade                      -- to Add Cascade Constraint to InvoiceLine Table
    FOREIGN KEY (InvoiceID) REFERENCES Invoice(InvoiceID) ON DELETE CASCADE;

DELETE FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walker';
-- Deleted 'Robert Walker' from the Customer Table



------------------------ 3.0 SQL Functions ------------------------

---------- 3.1 System Defined Functions ----------
-- Created a function that returns the current time.
CREATE or REPLACE FUNCTION currentTime
RETURN TIMESTAMP
AS currentT TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO currentT FROM Dual;
    RETURN currentT;
END;
/
--SELECT currentTime FROM Dual;

-- Created a function that returns the length of a mediatype from the mediatype table
CREATE or REPLACE FUNCTION mediaLength (mtid NUMBER)
RETURN NUMBER
AS currentLength NUMBER(30);
BEGIN
    SELECT LENGTH(m.NAME) INTO currentLength FROM MediaType m
    WHERE m.MEDIATYPEID = mtid;
    RETURN currentLength;
END;
/
--SELECT mediaLength(5) FROM Dual;


---------- 3.2 System Defined Aggregate Functions ----------
-- Create a function that returns the average total of all invoices                 
CREATE or REPLACE FUNCTION AverageTotal
RETURN NUMBER
AS avgTotal NUMBER(30,4);
BEGIN
    SELECT AVG(TOTAL) INTO avgTotal FROM INVOICE;
    RETURN avgTotal;
END;
/
--SELECT AverageTotal FROM Dual;

-- Create a function that returns the most expensive track  
CREATE or REPLACE FUNCTION maxPrice
RETURN NUMBER
AS mP NUMBER (30,2);
BEGIN
    SELECT MAX(UnitPrice) INTO mP FROM Track;
    RETURN mP;
END;
/
--SELECT maxPrice FROM Dual;



---------- 3.3 User Defined Functions ----------
-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE or REPLACE FUNCTION avgInvoicePrice
RETURN NUMBER
AS aIP NUMBER(30,4);
BEGIN
    SELECT AVG(UNITPRICE) INTO aIP FROM INVOICELINE;
    RETURN aIP;
END;
/
--SELECT avgInvoicePrice FROM Dual;



---------- 3.4 User Defined Table Valued Functions ----------
-- Created a function that returns all employees who are born after 1968.
CREATE or REPLACE TYPE EmployeeType FORCE AS OBJECT (fName VARCHAR2(50), lName VARCHAR2(30), bDate DATE);
/
CREATE or REPLACE TYPE Table_EmployeeType AS TABLE OF EmployeeType;
/
CREATE or REPLACE FUNCTION Employee1968
RETURN Table_EmployeeType PIPELINED
AS
BEGIN
    FOR A IN (SELECT FirstName, LastName, BirthDate FROM Employee WHERE BirthDate >= '01-JAN-1969') LOOP
        PIPE ROW (EmployeeType(A.LastName, A.FirstName, A.BirthDate));
    END LOOP;
RETURN;
END Employee1968;
/
SELECT * FROM TABLE(Employee1968());



------------------------ 4.0 SQL Procedures ------------------------

---------- 4.1 Basic Stored Procedure ----------
-- Created a stored procedure that selects the first and last names of all the employees.
CREATE or REPLACE PROCEDURE getFullName(emp_cursor OUT SYS_REFCURSOR)
IS 
BEGIN 
    OPEN emp_cursor FOR
    SELECT FirstName, LastName FROM Employee;
END;
/
DECLARE
    curs SYS_REFCURSOR;
    lName Employee.LastName%TYPE;
    fName Employee.FirstName%TYPE;
BEGIN
    getFullName(curs);
    LOOP
        FETCH curs INTO lName, fName;
        EXIT WHEN curs%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(lName || ' ' || fName);
    END LOOP;
    CLOSE curs;
END;
/


---------- 4.2 Stored Procedure Input Parameters ----------
-- Created a stored procedure that updates the personal information of an employee.
CREATE or REPLACE PROCEDURE updateEmployee(id NUMBER, tit VARCHAR2, rt NUMBER, bd DATE, hd DATE, add VARCHAR2, city VARCHAR2, state VARCHAR2,
                ctry VARCHAR2, zip VARCHAR2, phone VARCHAR2, fax VARCHAR2, email VARCHAR2)
AS 
BEGIN
    UPDATE Employee e
    SET e.Title = tit, e.ReportsTo = rt, e.BirthDate = bd, e.HireDate = hd, e.Address = add, e.City = City, e.State = State,
                e.Country = ctry, e.PostalCode = zip, e.Phone = phone, e.Fax = fax, e.Email = email
    WHERE e.EmployeeID = id;
END;
/
BEGIN
    updateEmployee(9, 'Vice General Manager', 1, '06-JUL-94', '23-DEC-17', '2100 Wordsworth Ct.', 'Herndon', 'VA', 'USA', '20170', '832-875-4627', '', 'random@gmail.com');
END;
/

-- Created a stored procedure that returns the managers of an employee.
CREATE or REPLACE PROCEDURE empManager(empNumber IN NUMBER, mngr OUT VARCHAR2)
AS
BEGIN
    SELECT (mng.FirstName || ' ' || mng.LastName) INTO mngr FROM Employee emp INNER JOIN employee mng ON mng.employeeid = emp.reportsto 
    WHERE emp.EmployeeID = empNumber;
END;
/
DECLARE
    mngr VARCHAR2(50);
    emp NUMBER := 9;
BEGIN
    empManager(emp, mngr);
    DBMS_OUTPUT.PUT_LINE('----- 4.2.2 -----');
    DBMS_OUTPUT.PUT_LINE('Employee: ' || emp || ' reports to Manager ' || mngr);
END;
/


---------- 4.3 Stored Procedure Output Parameters ----------
-- Created a stored procedure that returns the name and company of a customer.
CREATE or REPLACE PROCEDURE customerNameComp (cus IN NUMBER, na OUT VARCHAR2, comp OUT VARCHAR2)
AS
BEGIN
    SELECT (c.FirstName || ' ' || c.LastName) INTO na FROM Customer c WHERE c.CustomerID = cus;
    SELECT c.Company INTO comp FROM Customer c WHERE c.CustomerID = cus;
END;
/
DECLARE
    cus NUMBER := 19;
    na VARCHAR2(50);
    comp VARCHAR2(50);
BEGIN
    customerNameComp(cus, na, comp);
    DBMS_OUTPUT.PUT_LINE('----- 4.3 -----');
    DBMS_OUTPUT.PUT_LINE('CustomerID: ' || cus);
    DBMS_OUTPUT.PUT_LINE('Customer Name: ' || na);
    DBMS_OUTPUT.PUT_LINE('Customer Company: ' || comp);
END;
/


------------------------ 5.0 Transactions ------------------------

-- Created a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE or REPLACE PROCEDURE deleteInvoice(invID IN NUMBER)
AS
BEGIN
    DELETE FROM Invoice i WHERE i.InvoiceID = invID;
--    COMMIT;
END;
/
BEGIN
    deleteInvoice(412);
END;

-- Created a transaction nested within a stored procedure that inserts a new record in the Customer table
SELECT * FROM Customer;
DESC CUSTOMER;
CREATE or REPLACE PROCEDURE addCustomer (cusID IN NUMBER, fName IN VARCHAR2, lName IN VARCHAR2, comp IN VARCHAR, 
                    addr IN VARCHAR2, ci IN VARCHAR2, st IN VARCHAR2, coun IN VARCHAR2, pc IN VARCHAR2, 
                    ph IN VARCHAR2, fx IN VARCHAR2, em VARCHAR2, spID IN NUMBER)
AS
BEGIN
    INSERT INTO Customer VALUES (cusID, fName, lName, comp, addr, ci, st, coun, pc, ph, fx, em, spID);
--    COMMIT;
END;
/
BEGIN
    addCustomer(62, 'Joseph', 'Fernandez', 'Revature', '11730 Plaza America Dr #205', 'Reston', 'VA', 'USA', '20190', '(703) 570-8181', '', 'revature.com', 2);
END;
/


------------------------ 6.0 Triggers ------------------------

---------- 6.1 AFTER/FOR ----------
-- Created an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE or REPLACE TRIGGER afterEmployeeInserted
AFTER INSERT ON Employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('----- New Employee Inserted -----');
END;
/

-- Created an after update trigger on the album table that fires after a row is inserted in the table
CREATE or REPLACE TRIGGER afterAlbumInsert
AFTER INSERT ON Album
BEGIN
    DBMS_OUTPUT.PUT_LINE('----- New Album Inserted -----');
END;
/

-- Created an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE or REPLACE TRIGGER afterCustomerDelete
AFTER DELETE ON Customer
BEGIN
    DBMS_OUTPUT.PUT_LINE('----- Customer Deleted -----');
END;
/


------------------------ 7.0 Joins ------------------------

---------- 7.1 INNER ----------
-- Created an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT c.FirstName, i.InvoiceID FROM Customer c INNER JOIN Invoice i ON c.CUSTOMERID = i.CUSTOMERID;



---------- 7.2 OUTER ----------
-- Created an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT c.CustomerID, c.FirstName, c.LastName, i.InvoiceID, i.Total FROM Customer c FULL OUTER JOIN Invoice i ON c.CUSTOMERID = i.CUSTOMERID;



---------- 7.3 RIGHT ----------
-- Created a right join that joins album and artist specifying artist name and title.
SELECT a2.Name, a1.Title FROM Album a1 RIGHT JOIN Artist a2 ON a1.ArtistID = a2.ArtistID;



---------- 7.4 CROSS ----------
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT a2.Name, a1.Title FROM Album a1 CROSS JOIN Artist a2 ORDER BY a2.Name ASC;



---------- 7.5 SELF ----------
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT e2.LastName, e1.LastName FROM Employee e1, Employee e2 WHERE e1.EmployeeID = e2.ReportsTo;



---------- 7.6 Complicated Join assignment ----------
--Create an inner join between all tables in the chinook database.
SELECT * FROM Invoice i1
    INNER JOIN InvoiceLine i2 ON i1.InvoiceID = i2.InvoiceID
    INNER JOIN Customer c ON i1.CustomerID = c.CustomerID
    INNER JOIN Employee e ON c.SupportrepID = e.EmployeeID
    INNER JOIN Track t ON i2.TrackID = t.TrackID
    INNER JOIN Genre g ON t.GenreID = g.GenreID
    INNER JOIN MediaType m ON t.MediaTypeID = m.MediaTypeID
    INNER JOIN Album a1 ON t.AlbumID = a1.AlbumID
    INNER JOIN Artist a2 ON a1.ArtistID = a2.ArtistID
    INNER JOIN PlaylistTrack p1 ON t.TrackID = p1.TrackID
    INNER JOIN Playlist p2 ON p1.PlaylistID = p2.PlaylistID;
  
  
  
---------- 9.0 Administration ----------
--Task – Create a .bak file for the Chinook database