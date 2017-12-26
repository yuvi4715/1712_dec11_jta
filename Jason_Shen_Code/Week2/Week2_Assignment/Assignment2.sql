--=========================
--2.1 Select
--=========================
--Task: Select all records from the Employee Table
select * from EMPLOYEE;

--Task: Select all records from the Employee table where last name is King.
select * from EMPLOYEE where LASTNAME='King';

--Task: Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from Employee where FIRSTNAME='Andrew' and REPORTSTO is NULL;

--=========================
--2.2 ORDER BY
--=========================
--Task – Select all albums in Album table and sort result set in descending order by title.
desc Album;
select * from Album order by TITLE desc;

--Task – Select first name from Customer and sort result set in ascending order by city
desc Customer;
select FIRSTNAME from Customer order by CITY asc;
--To see if the above query returned what I actually wanted, I'll also select the cities
select FIRSTNAME, CITY from Customer order by CITY asc;

--=========================
--2.3 INSERT INTO
--=========================
-- Task – Insert two new records into Genre table

--Check table fields to know how to insert into the table
desc Genre;
--The following queries return a unique constraint error
insert into Genre (GENREID, NAME) 
    values(1, 'Jazz');
insert into Genre (GENREID, NAME) 
    values(2, 'Rock');

--Check the constraints, we see that the constraint error corresponds to error regarding primary keys
select * from USER_CONSTRAINTS where TABLE_NAME='GENRE';
--Let's look at the table to see what primary keys have been taken
select * from GENRE;
--It looks like there's already 25 entries, so we'll insert 26 and 27
insert into Genre (GENREID, NAME) 
    values(26, 'Jazz');
insert into Genre (GENREID, NAME) 
    values(27, 'Rock');
    
--Task – Insert two new records into Employee table
--Following the same process as previous task...

desc Employee;
select * from Employee;
insert into Employee
    values(9, 'Shen', 'Jason', 'Associate', 2, '29-MAY-95', 
            '11-DEC-17', '508 Pride Ave', 'Herndon', 'VA', 'USA', '20170',
            '+1 (516) 4691128', null, 'shenj529@gmail.com');
--Left remaining values null            
insert into Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO)
    values(10, 'Pham', 'Tuan', 'Associate', 2);
    
--Task – Insert two new records into Customer table
desc Customer;
select * from Customer order by CUSTOMERID desc;
insert into Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
    values(60, 'Andy', 'Kim', 'andykim123@gmail.com');
insert into Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
    values(61, 'Kathy', 'Zhang', 'luckykathy123@gmail.com');
--Check that we added them:
select * from Customer;
    
--=========================
--2.4 UPDATE
--=========================

--Task – Update Aaron Mitchell in Customer table to Robert Walter
desc CUSTOMER;
select CUSTOMERID from CUSTOMER 
    where FIRSTNAME='Aaron' and LASTNAME='Mitchell'; --ID = 32
update CUSTOMER 
    set FIRSTNAME='Robert', LASTNAME='Walker' 
    where CUSTOMERID=32;
    
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
desc ARTIST;
update Artist set NAME='CCR' where NAME='Creedence Clearwater Revival';
--Check that it's updated:
select * from artist where name='CCR';

--=========================
--2.5 LIKE
--=========================

--Task – Select all invoices with a billing address like “T%”
desc INVOICE;
select * from invoice where billingaddress like 'T%';

--=========================
--2.6 BETWEEN
--=========================

--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;

--Task – Select all employees hired between 1st of June 2003 and 
--1st of March 2004
select * from employee where HIREDATE between '1-JUN-03' and '1-MAR-04';

--=========================
--2.7 DELETE
--=========================
desc customer;
delete from customer where firstname='Robert' and lastname='Walker';
--This will throw an error because there exists a child record that references
--the record in customer.

select * from customer;

--Used ERD to check the relationships to trace references back from
--Customer to Invoice to Invoiceline (InvoiceID -> CustomerID -> Name)
--Is there any way to check this using a query instead of the ERD?
--      ^
--      |
--      |
--      |
--      |-------- I think I figured this out, see below block: 

-- ==============================
--This line gives you information about the primary key of the customer table.
select * from USER_CONSTRAINTS where Table_name='CUSTOMER' and CONSTRAINT_TYPE='P';
--This line tells you which referencing constraints are referencing the above primary key
--Under TABLE_NAME it indicates that INVOICE is what is using this reference key to 
--  Customer's Primary Key
select * from USER_CONSTRAINTS where R_CONSTRAINT_NAME = 'PK_CUSTOMER';

--Combining it you would do:
select * from USER_CONSTRAINTS where R_CONSTRAINT_NAME = (
    select CONSTRAINT_NAME 
    from USER_CONSTRAINTS 
    where Table_name='CUSTOMER' and CONSTRAINT_TYPE='P');
-- ==============================

delete from invoiceline 
where invoiceid in (
    select invoiceid from invoice 
    where customerid in (
        select customerid from customer
        where firstname='Robert' and lastname='Walker'));
        
delete from invoice
where customerid in (
    select customerid from customer
    where firstname='Robert' and lastname='Walker');
    
delete from customer 
where firstname='Robert' and lastname='Walker';
    
--Check that we deleted it
select count(*) from customer 
    where firstname='Robert' and lastname='Walker'; --Count(*) = 0
    
--==============================
--3.1 SYSTEM DEFINED FUNCTIONS
--==============================
--Task – Create a function that returns the current time.

--Creating the function to get current time
/
CREATE OR REPLACE Function myGetTime
    RETURN VARCHAR2
AS
    --Varchar variable to store the result
    mytime VARCHAR2(30); 
BEGIN
--    Using the system function localtimestamp corrects for timezone
    mytime := to_char(LOCALTIMESTAMP, 'HH:MI:SS');
    --Return result
    return mytime;
END;
/

--Outputting to see if function works correctly.
declare
    mytime varchar2(30);
begin
    mytime := MYGETTIME;
    DBMS_OUTPUT.PUT_LINE(mytime);
end;
/

--Task – create a function that returns the length of a mediatype from the mediatype table
--Let's see what the mediatype table looks like
desc MEDIATYPE;
select * from MEDIATYPE;
/
create or replace function getMediaLength(mediaID NUMBER)
    return NUMBER
as
    medialength NUMBER;
    mediastring varchar2(30);
begin
    select NAME into mediastring from MEDIATYPE where MEDIATYPEID = mediaID;
    medialength := LENGTH(mediastring);
    return medialength;
end;
/

--Output to see if function works as intended
declare
    medialength number;
begin
    medialength := getmedialength(3); --"Protected MPEG-4 video file"
    
    DBMS_output.put_line(medialength);
end;
/


--========================================
--3.1 SYSTEM DEFINED AGGREGATE FUNCTIONS
--========================================

--Task – Create a function that returns the average total of all invoices
select * from invoice;
select avg(total) from invoice;
create or replace function invoiceavgtotal
    return number
as 
    averagetotal number;
begin
    select avg(total) into averagetotal from invoice;
    return averagetotal;
end;
/
declare
    averagetotal number;
begin
    averagetotal := invoiceavgtotal;
    DBMS_output.put_line(averagetotal);
end;
/

--Task – Create a function that returns the most expensive track
desc track;
select * from track;
create or replace function maxCostTrack
    return number
as
    maxcost number;
begin
    select max(unitprice) into maxcost from track;
    return maxcost;
end;
/
declare
    maxcost number;
begin
    maxcost := maxCostTrack;
    DBMS_output.put_line(maxcost);
end;
/


--========================================
--3.3 USER DEFINED FUNCTIONS
--========================================

--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
select * from invoiceline;
--It looks like it provides the price per unit and the quantity.
--So to find the average price per item, we should do 
--Sum of prices / sum of quantities
create or replace function averagePriceIL
    return number
as
    unit_price_sum number;
    quantity_sum number;
begin
    select sum(unitprice) into unit_price_sum from invoiceline;
    select sum(quantity) into quantity_sum from invoiceline;
    return unit_price_sum / quantity_sum;
end;
/

declare
    invoice_avg number;
begin
    invoice_avg := averagePriceIL;
    DBMS_output.put_line(invoice_avg);
end;
/


--========================================
--3.4 User Defined Table Valued Functions
--========================================
--Task – Create a function that returns all employees who are born after 1968.
desc employee;
select * from employee;
select * from employee where birthdate between '31-DEC-67' and CURRENT_DATE;

--Creating function to return the specified employees as a cursor to those values
create or replace function BornAfter1968 return SYS_REFCURSOR 
as 
    emp_cursor SYS_REFCURSOR;
BEGIN
    open emp_cursor for select firstname, lastname,birthdate from employee where BIRTHDATE > '31-DEC-1967' ;
    RETURN emp_cursor;
END;
/
--Checking our function
select BornAfter1968 from dual;

--========================================
--4.1 Basic Stored Procedure
--========================================
--Task – Create a stored procedure that selects the first and last names of all the employees.
--As far as what I've learned so far, in functions and procedures, you can
-- not directly return a query or stored procedure. You have to use cursors. 
create or replace procedure ProcGetEmpNames
as
    empNamesCursor SYS_REFCURSOR;
    varfirstname VARCHAR2(30);
    varlastname VARCHAR2(30);
begin
    open empNamesCursor for select firstname, lastname from employee;
    loop
        fetch empNamesCursor INTO varfirstname, varlastname;
        exit when empNamesCursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(varfirstname|| ', ' || varlastname);
    end loop;    
end;
/

begin
    PROCGETEMPNAMES;
end;
/


--========================================
--4.2 Stored Procedure Input Parameters
--========================================
--Task – Create a stored procedure that updates the personal information of an employee.

create or replace procedure UpdateEmpNames (
    varPrevFirstName in varchar, varPrevLastName in varchar, 
    varNewFirstName in varchar, varNewLastName in varchar)
as
begin
    update employee 
    set firstname = varnewfirstName, lastname = varnewLastName
    where firstname = varprevfirstname and lastname = varprevlastname;
end;
/
declare

--Calling our procedure
begin
    UpdateEmpNames('Jason','Shen','Eric','Shen');
end;
/
--Checking to see if it worked
select * from employee;
/
--Calling our procedure again to revert
begin
    UpdateEmpNames('Eric','Shen','Jason','Shen');
end;
/
--Successful in reverting
select * from employee;
        
--Task – Create a stored procedure that returns the managers of an employee.
--Setting up the proedure to take in as an argument the ID of the employee
-- we want to know about
create or replace procedure getManager(empID in number)
as 
    managerCursor SYS_REFCURSOR;
    varEmpID number;
    empFirstName varchar(30);
    empLastName varchar(30);
    managerID number;
    managerFirstName varchar(30);
    managerLastName varchar(30);
begin
    open managerCursor for 
    --Using a self join here
    select e1.EMPLOYEEID, e1.FIRSTNAME, e1.LASTNAME,
           e2.EMPLOYEEID, e2.FIRSTNAME, e2.LASTNAME 
    from employee e1, employee e2
        where e1.employeeID = empID and e1.reportsto = e2.employeeid;
    loop 
        fetch managerCursor into 
            varEmpID, empFirstName, empLastName,
            managerID, managerFirstName, managerLastName;
        exit when managerCursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Employee: ' || empFirstName || ' ' || empLastName
            || ', Manager: ' || managerFirstName || ' ' || managerLastName);
    end loop;
end;
/
--Testing our procedure..
begin
    getManager(4);
end;
/



--========================================
--4.3 Stored Procedure Output Parameters
--========================================
--Task – Create a stored procedure that returns the name and company of a customer.
select * from customer;

create or replace procedure getNameAndCompany(
    varCustomerID in number,
    customerFirstName out varchar,
    customerLastName out varchar,
    customerCompany out varchar)
as
begin
    select firstname, lastname, company 
    into customerFirstName, customerLastName, customerCompany
    from customer
    where customerid = varCustomerID;
end;
/

declare
    customerID number;
    customerFirstName varchar(40);
    customerLastName varchar(30);
    customerCompany varchar(80);  
begin
    customerID := 1;
    getNameAndCompany(customerID, customerFirstName, customerLastName, customerCompany);
    DBMS_OUTPUT.PUT_LINE('ID: '||customerID);
    DBMS_OUTPUT.PUT_LINE('Name: '|| customerFirstName || ' ' || customerLastName);
    DBMS_OUTPUT.PUT_LINE('Company: ' || customerCompany);
end;
/

--========================================
--5.0 Transactions
--========================================

--Task – Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).

select * from invoice;

--Creating a procedure for deleting the invoice
create or replace procedure deleteInvoice (toDeleteID in number)
as
begin
    delete from invoiceline where invoiceID = toDeleteID;
    delete from invoice where invoiceID = toDeleteID;
end;
/

--Calling the procedure as our transaction
begin
    savepoint beforeInvoiceDelete;
    deleteInvoice(5);
    commit;
end;
/

select * from customer;


--Task – Create a transaction nested within a stored procedure that inserts a 
--new record in the Customer table

create or replace procedure insertRecord (
    customerID in number,
    firstname in varchar,
    lastname in varchar,
    company in varchar default null,
    address in varchar default null,
    city in varchar default null,
    state in varchar default null,
    country in varchar default null,
    postalcode in varchar default null,
    phone in varchar default null,
    fax in varchar default null,
    email in varchar,
    supportrepid in number default null)
as
begin
    insert into customer values (
        customerID,
        firstname,
        lastname,
        company,
        address,
        city,
        state,
        country,
        postalcode,
        phone,
        fax,
        email,
        supportrepid);   
        
    --Committing our transaction
    commit;
end;
/

--Testing our transaction procedure
begin
    INSERTRECORD(62, 'Adriel', 'Leung', null, null , null , null , 
    null, null, null, null, 'adrieleung@gmail.com', null);
end;
/

--========================================
--6.1 AFTER/FOR
--========================================
--Task - Create an after insert trigger on the employee table fired after a 
--new record is inserted into the table.
create or replace trigger afterInsert
after insert on employee
for each row
begin
    DBMS_OUTPUT.PUT_LINE('New employee added.');
end;
/

--Testing our trigger..
--The output from the trigger only seems to appear when we run the entire script 
-- and not just a block of the script.
insert into employee (EMPLOYEEID, LASTNAME, FIRSTNAME) values(15, 'Paek', 'Andrew');

--Task – Create an after update trigger on the album table that fires after 
--a row is inserted in the table

-- I assume this is a typo and that you want an update trigger after
-- a row is updated??
/
create or replace trigger afterAlbumUpdate
after update on Album
for each row
begin
    DBMS_OUTPUT.PUT_LINE('Old title: ' || :OLD.TITLE);
    DBMS_OUTPUT.PUT_LINE('New title: ' || :NEW.TITLE);
end;
/

--Testing our trigger..
update album set TITLE = 'Testing our trigger!' where albumid = 1;

--Task – Create an after delete trigger on the customer table that fires after 
--a row is deleted from the table.

create or replace trigger afterCustomerDelete
after delete on customer
for each row
begin 
    DBMS_OUTPUT.PUT_LINE(:OLD.FIRSTNAME || ' ' || :OLD.LASTNAME || ' deleted.');
end;
/

--========================================
--7.1 INNER JOINS
--========================================

--Task – Create an inner join that joins customers and orders and
--specifies the name of the customer and the invoiceId.
--TESTING MYSELF:
--THE EXPECTED OUTPUT SHOULD BE ALL CUSTOMERS THAT HAVE A CORRESPONDING INVOICEID.
--IF INVOICEID IS NULL, IT SHOULD NOT BE LISTED IN THIS RESULTSET.
select customer.customerid, firstname, lastname, invoiceid from customer 
inner join invoice on customer.customerid = invoice.customerid;


--========================================
--7.2 OUTER (LEFT) JOINS
--========================================
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.
--TESTING MYSELF:
--THIS TIME, IT SHOULD ALSO LIST THE CUSTOMERS THAT ALSO HAVE NULL INVOICEIDS/TOTALS.
select customer.customerid, firstname, lastname, invoiceid, total from customer
left join invoice on customer.customerid = invoice.customerid;


--========================================
--7.3 OUTER (RIGHT) JOINS
--========================================
--Task – Create a right join that joins album and artist specifying artist name and title.
--TESTING SELF:
--We can either do a query on artists with albums joined.
--  This has all the artists with their albums, with potential null values under albums
--Or we can do a query on albums with artists joined.
--  This has all albums with their respective artists with potential null values under artist
select name, title from artist
right join album on artist.artistid = album.artistid;


--========================================
--7.4 CROSS JOINS
--========================================
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
--Forms the cartestian product between albums and artists. Meaning that every album
-- is now related to every artist.
select albumid, title, album.artistid, artist.name from album
cross join artist;


--========================================
--7.5 SELF JOINS
--========================================
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select e1.firstname, e1.lastname, e1.reportsto, e2.firstname, e2.lastname, e2.reportsto
from employee e1, employee e2
where e1.reportsto = e2.reportsto
order by e1.reportsto;

--========================================
--7.6 COMPLICATED JOIN ASSIGNMENT
--========================================
--Create an inner join between all tables in the chinook database.

select * from customer
    join invoice on customer.customerid = invoice.customerid
    join invoiceline on invoiceline.invoiceid = invoice.invoiceid
    join employee on employee.employeeid = customer.supportrepid
    join track on invoiceline.trackid = track.trackid
    
    join genre on track.genreid = genre.genreid
    
    join mediatype on track.mediatypeid = mediatype.mediatypeid
    
    --Order matters, see ERD
    join album on track.albumid = album.albumid
    join artist on album.artistid = artist.artistid
    
    join playlisttrack on track.trackid = playlisttrack.trackid
    join playlist on playlist.playlistid = playlisttrack.playlistid;

--========================================
--9.0 ADMINISTRATION
--========================================
--Task – Create a .bak file for the Chinook database    