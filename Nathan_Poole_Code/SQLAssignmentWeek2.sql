--=2.1==========================================================================

--Done
--Select all records from the Employee table
select * from Employee;

--Done
--Select all records from the Employee table where last name is King.
SELECT * FROM Employee 
    WHERE lastname='King';
    
--Done
--Select all records from the Employee table where first name is Andrew and 
--  REPORTSTO is NULL
select * from Employee 
    where FIRSTNAME='Andrew' AND REPORTSTO is NULL;

--=2.2==========================================================================

--Done
--Select all albums in Album table and sort result set in descending order by
--  title.
select * from Album 
    order by title desc;
    
--Done
--Select first name from Customer and sort result set in ascending order by city
select firstname from CUSTOMER 
    order by city asc;

--=2.3==========================================================================

--Done
--Insert two new records into Genre table
insert into genre 
    values (26, 'Eurobeat');
insert into genre(GENREID, NAME) 
    values (27, 'Big Band');
    
--Done
--Insert two new records into Employee table
insert into Employee (EmployeeId, LastName, FirstName, Title, REPORTSTO, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
    values ( 9, 'Thompson', 'Liam', 'Garbage Boy', 1, TO_DATE('1999-6-13 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2017-12-15 00:00:00','yyyy-mm-dd hh24:mi:ss'), '15426 Nowhere St', 'Edmonton', 'AB', 'Canada', 'T5K 5J4', '+1 (780) 428-5581', '+1 (780) 428-6124', 'lisa@chinookcorp.com');
insert into Employee (EmployeeId, LastName, FirstName, Title, REPORTSTO, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
    values (10, 'Brablepelt', 'Lisa', 'Graphic Artist', 1, TO_DATE('1995-10-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2010-11-7 00:00:00','yyyy-mm-dd hh24:mi:ss'), '18749 Equinox Dr', 'Lethbridge', 'AB', 'Canada', 'T1K 5N7', '+1 (403) 456-8581', '+1 (403) 456-7146', 'liam@chinookcorp.com');

--Done
--Insert two new records into Customer table
insert into CUSTOMER 
    values( 60, 'Mike', 'Smith', null, '27 Los Santos Blvd', 'Los Santos', null, 'USA', '65646', '+1 (555) 247-7423', null, 'mike.smith@gmail.com', 5); 
insert into CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, ADDRESS, CITY, STATE, COUNTRY, PHONE, EMAIL, SUPPORTREPID)
    VALUES (61, 'Vivian', 'Delando', '2606 Adams Dr.', 'New York', 'New York', 'USA', '+1 (487) 567-9281', 'vivian.delando@hotmail.com', 3);

--=2.4==========================================================================

--Done
--Update Aaron Mitchell in Customer table to Robert Walter
update CUSTOMER 
    set FIRSTNAME='Robert',LASTNAME='Walter'
    where FIRSTNAME='Aaron' and LASTNAME='Mitchell';

--Done
--Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
update ARTIST
    set NAME='CCR'
    where NAME='Creedence Clearwater Revival';



--=2.5==========================================================================

--Done
--Select all invoices with a billing address like “T%”
select * from INVOICE
    where BILLINGADDRESS like 'T%';

--=2.6==========================================================================
 
 --Done
 --Select all invoices that have a total between 15 and 50
 select * from INVOICE
    where TOTAL between 15 and 50;
 
 --Done
 --Select all employees hired between 1st of June 2003 and 1st of March 2004
 select * from EMPLOYEE
    where HIREDATE between TO_DATE ('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') 
    and 
    TO_DATE ('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
    
--=2.7==========================================================================

--Done
--Delete a record in Customer table where the name is Robert Walter (There may 
--  be constraints that rely on this, find out how to resolve them).

/*
in order to delete a customer you must first delete all references to their 
    CUSTOMERID in INVOICE
in order to delete a customer's invoice you have to delete all the refernces to 
    the INVOICEIDs in INVOICELINE;
*/

--Deleting INVOICELINE records with related INVOICEIDs
Delete from INVOICELINE
    where INVOICEID in (50, 61, 342, 116, 245, 268, 290);
--Deleting INVOICE records with related CUSTOMERIDs
Delete from INVOICE
    where CUSTOMERID=32;
--Deleting Customer
Delete from CUSTOMER
    where 
        FIRSTNAME='Robert' 
        and LASTNAME='Walter';
        
--=3.1==========================================================================

--Done
--Create a function that returns the current time.
CREATE OR REPLACE FUNCTION WHATTIMEISIT 
RETURN timestamp 
AS 
BEGIN
   return LOCALTIMESTAMP;
END
;
/
select WHATTIMEISIT from dual;



--Done
--create a function that returns the length of a mediatype from the mediatype 
--  table
create or replace function getMediaLength(mtid number)
return VARCHAR
as mediaTypeLength varchar(30);
begin
    select name into mediaTypeLength 
    from mediatype
    where MEDIATYPEID = mtid;
    return length(mediaTypeLength);
end
;
/
select getMediaLength(1) from dual;

select name 
from mediatype
where MEDIATYPEID=1;

--=3.2==========================================================================   

--Done--
--Create a function that returns the average total of all invoices
create or replace function avgInvoices
return NUMBER
as avgInv NUMBER(10, 2);
begin
    select avg(total) into avgInv from invoice;
    return avgInv;
end
;
/
select avgInvoices from dual;

--Done
--Create a function that returns the most expensive track
Create or replace function getGreatestTrack
return number
as trackPrice number(10,2);
begin
    select max(distinct(t.unitprice)) into trackPrice 
    from track t;
    return trackPrice;
end
;
/
select getGreatestTrack from dual;

--=3.3==========================================================================

--Done
--Create a function that returns the average price of invoiceline items in the 
--  invoiceline table
create or replace function avgInvoiceLine
return NUMBER
as avgInvLn NUMBER(10, 2);
begin
    select avg(unitprice) into avgInvLn from invoiceline;
    return avgInvLn;
end
;
/
select avgInvoiceLine from dual;

--=3.4==========================================================================

--Done
--Create a function that returns all employees who are born after 1968.
create or replace function employeeBirth
return sys_refcursor
as empRecords SYS_REFCURSOR;
begin
    open empRecords for
    select * from employee 
       where birthdate > TO_DATE('1968-12-31 23:59:59','yyyy-mm-dd hh24:mi:ss');
    return empRecords;
end
;
/
select employeeBirth from dual;

--=4.1==========================================================================

--DONE--
--Create a stored procedure that selects the first and last names of all the 
--  employees.
CREATE OR REPLACE PROCEDURE requestEmpFirstLast(NAMECURSOR OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN NAMECURSOR FOR SELECT FIRSTNAME, LASTNAME
    FROM EMPLOYEE;
END;
/

DECLARE
	NAMELISTCURSOR SYS_REFCURSOR;
	FIRSTNAME VARCHAR(20);
    LASTNAME VARCHAR(20);
BEGIN
	requestEmpFirstLast(NAMELISTCURSOR);
	LOOP
		FETCH NAMELISTCURSOR INTO FIRSTNAME, LASTNAME;
		EXIT WHEN NAMELISTCURSOR%NOTFOUND;
		DBMS_OUTPUT.PUT_LINE('Employee full name is ' || FIRSTNAME || ' ' || 
            LASTNAME);
	
	END LOOP;
END;
/

--=4.2==========================================================================

--DONE--
--Create a stored procedure that updates the personal information of an employee
create or replace procedure updateEmployee
                            (EMP_ID IN NUMBER,
                             EMPFIRSTNAME in varchar,
                             EMPLASTNAME IN VARCHAR,
                             EMPADDRESS IN VARCHAR,
                             EMPCITY IN VARCHAR,
                             EMPSTATE IN VARCHAR,
                             EMPCOUNTRY IN VARCHAR,
                             EMPPOSTALCODE IN VARCHAR,
                             EMPPHONE IN VARCHAR,
                             EMPFAX IN VARCHAR,
                             EMPEMAIL IN VARCHAR)
as
begin
    update EMPLOYEE
    set FIRSTNAME=EMPFIRSTNAME, LASTNAME=EMPLASTNAME, ADDRESS=EMPADDRESS, 
        CITY=EMPCITY, STATE=EMPSTATE, COUNTRY=EMPCOUNTRY, POSTALCODE=EMPPOSTALCODE, 
        PHONE=EMPPHONE, FAX=EMPFAX , EMAIL=EMPEMAIL 
        where EMPLOYEEID = EMP_ID;
end
;
/

EXEC UPDATEEMPLOYEE(5, 'NATHAN', 'POOLE', '24999 OLD HIGHWAY 18', 'TECUMESH', 'OKLAHOMA', 'USA', '74873', '405-585-8132', NULL, 'NATHAN.POOLED@GMAIL.COM');
SELECT * FROM EMPLOYEE WHERE EMPLOYEEID=5;

--pending--
--Create a stored procedure that returns the managers of an employee.
create or replace procedure employee.traceManagers
                            (eid in number)
as mid number(10);
begin
    select reportsto into mid
        from employee
        where employeeid = eid;

    select * 
        from employee
        where employeeid = mid;
end;
/

--=4.3==========================================================================

--DONE--
--Create a stored procedure that returns the name and company of a customer.
create or replace procedure customerCompany
                            (cid in number,
                             customerInfo out sys_refcursor)
as
begin
    open customerInfo for
    select firstname, lastname, company 
    from customer
    where customerid = cid;
end
;
/

DECLARE
	CUSTOMERLISTCURSOR SYS_REFCURSOR;
	FIRSTNAME VARCHAR(40);
    LASTNAME VARCHAR(20);
    COMPANY VARCHAR(80);
BEGIN
	customerCompany(1 ,CUSTOMERLISTCURSOR);
	LOOP
		FETCH CUSTOMERLISTCURSOR INTO FIRSTNAME, LASTNAME, COMPANY;
		EXIT WHEN CUSTOMERLISTCURSOR%NOTFOUND;
		DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ' ' || LASTNAME||' '|| COMPANY);
	
	END LOOP;
END;
/

--=5.0==========================================================================

--DONE--
--Create a transaction that given a invoiceId will delete that invoice (There 
--  may be constraints that rely on this, find out how to resolve them).
DECLARE
    INVID NUMBER(10) := 1;
START TRANSACTION;
BEGIN
    savepoint before_invoice_delete;
    Delete FROM INVOICELINE
        where INVOICEID = INVID;
    Delete from INVOICE
        where INVOICEID = INVID;
    EXCEPTION
        WHEN INVALID_NUMBER THEN
            ROLLBACK TO SAVEPOINT before_invoice_delete;
        WHEN PROGRAM_ERROR THEN
            ROLLBACK TO SAVEPOINT before_invoice_delete;
COMMIT;
end;
/
--DONE--
--Create a transaction nested within a stored procedure that inserts a new 
--  record in the Customer table

CREATE OR REPLACE PROCEDURE CREATENEWCUSTOMER
    (CID IN NUMBER(10),
    NEWFIRST IN VARCHAR2(40),
    NEWLAST IN VARCHAR2(20),
    NEWCOMPANY IN VARCHAR2(80),
    NEWADDRESS IN VARCHAR2(70),
    NEWCITY IN VARCHAR2(40),
    NEWSTATE IN VARCHAR2(40),
    NEWCOURNTRY IN VARCHAR2(40),
    NEWPOSTCODE IN VARCHAR2(10),
    NEWPHONE IN VARCHAR2(24),
    NEWFAX IN VARCHAR2(24),
    NEWEMAIL IN VARCHAR(60),
    NEWREPID IN NUMBER(10))
BEGIN
    START TRANSACTION
        BEGIN
            SAVEPOINT BEFORE_NEW_CUSTOMER;
            INSERT INTO CUSTOMER
            VALUES(CID, NEWFIRST, NEWLAST, NEWCOMPANY, NEWADDRESS, NEWCITY, 
                    NEWSTATE, NEWCOUNTRY, NEWPOSTCODE, NEWPHONE, NEWFAX, 
                    NEWEMAIL, NEWREPID);
            EXCEPTION
                 WHEN PROGRAM_ERROR THEN
                    ROLLBACK TO SAVEPOINT BEFORE_NEW_CUSTOMER;
        COMMIT;
END;
/

--=6.1==========================================================================

--DONE--
-- Create an after insert trigger on the employee table fired after a new record 
--  is inserted into the table.
CREATE OR REPLACE TRIGGER NEWEMPLOYEEADDED
AFTER INSERT ON EMPLOYEE FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New employee added');
END;
/

--DONE--
-- Create an after update trigger on the album table that fires after a row is 
--  inserted in the table
CREATE OR REPLACE TRIGGER ALBUMUPDATED
AFTER INSERT ON ALBUM FOR EACH ROW
BEGIN
        DBMS_OUTPUT.PUT_LINE('Album table updated');
END;
/

--DONE--
-- Create an after delete trigger on the customer table that fires after a row 
--  is deleted from the table.
CREATE OR REPLACE TRIGGER CUSTOMERDELETED
AFTER DELETE ON CUSTOMER FOR EACH ROW
BEGIN
        DBMS_OUTPUT.PUT_LINE('Customer deleted');
END;
/

--=7.1==========================================================================

--Done--
--Create an inner join that joins customers and orders and specifies the name of 
--  the customer and the invoiceId.
select c.firstname, c.lastname, i.INVOICEID
    from customer c join invoice i
    on c.customerid = i.CUSTOMERID;
    
--=7.2==========================================================================

--DONE--
--Create an outer join that joins the customer and invoice table, specifying the 
--  CustomerId, firstname, lastname, invoiceId, and total.
select c.CustomerId, c.firstname, c.lastname, i.invoiceId, i.total
    from customer c full join invoice i
    on c.customerid = i.customerid;

--=7.3==========================================================================

--DONE--
--Create a right join that joins album and artist specifying artist name and 
--  title.
select r.NAME, a.title
    from album a right join artist r
    on a.artistid = r.artistid;

--=7.4==========================================================================

--DONE--
--Create a cross join that joins album and artist and sorts by artist name in 
--  ascending order.
select *
    FROM ALBUM , ARTIST 
    ORDER BY NAME;

--=7.5==========================================================================

--DONE--
--Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.EMPLOYEEID, A.FIRSTNAME, A.LASTNAME, A.REPORTSTO, B.FIRSTNAME, 
        B.LASTNAME, B.REPORTSTO
    FROM EMPLOYEE A, EMPLOYEE B
    WHERE A.REPORTSTO = B.REPORTSTO;

--=7.6==========================================================================

--DONE--
--Create an inner join between all tables in the chinook database.
SELECT *
    FROM INVOICELINE L JOIN INVOICE I 
        ON L.INVOICEID = I.INVOICEID
    JOIN CUSTOMER C 
        ON I.CUSTOMERID = C.CUSTOMERID
    JOIN EMPLOYEE E
        ON C.SUPPORTREPID = E.EMPLOYEEID
    JOIN TRACK T
        ON L.TRACKID = T.TRACKID
    JOIN GENRE G
        ON T.GENREID = G.GENREID
    JOIN MEDIATYPE M
        ON T.MEDIATYPEID = M.MEDIATYPEID
    JOIN ALBUM A
        ON T.ALBUMID = A.ALBUMID
    JOIN ARTIST R
        ON A.ARTISTID = R.ARTISTID
    JOIN PLAYLISTTRACK P
        ON P.TRACKID = T.TRACKID
    JOIN PLAYLIST Q
        ON P.PLAYLISTID = Q.PLAYLISTID;
        

--=9.0==========================================================================

--DONE--
--Create a .bak file for the Chinook database


    
    
    