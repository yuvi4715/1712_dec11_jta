--2.1
--Select all records from the Employee table. 
SELECT * FROM EMPLOYEE;
/

-- Select all records from the Employee table where last name is King. 
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
/

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. 
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
/

--2.2
--Task – Select all albums in Album table and sort result set in descending order by title. 
Select * from ALBUM 
ORDER BY TITLE DESC; --Use DESC for descending order
/

--Task – Select first name from Customer and sort result set in ascending order by city 
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC; --Use ASC for ascending order
/

--2.3
--Task – Insert two new records into Genre table 
INSERT INTO GENRE VALUES(26, 'House');
INSERT INTO GENRE VALUES(27, 'Western');
/

--Task – Insert two new records into Employee table 
INSERT INTO EMPLOYEE
VALUES(9, 'Ander', 'Rodriquez', 'Trainee', '5', '20-Nov-92', '15-Jun-15', '123 Point Rider', 'Herndon', 'VA', 'United States', '20171', '+1 (703) 834-0811', '+1 (265) 800-3502', 'ander@chinookcorp.com');
INSERT INTO EMPLOYEE
VALUES(10, 'Anna', 'Merill', 'IT Staff', '5', '11-Aug-92', '16-Jul-16', '456 Cool St', 'Reston', 'VA', 'United States', '20172', '+1 (703) 823-4029', '+1 (564) 365-0493', 'anna@chinookcorp.com');
/

--Task – Insert two new records into Customer table 
INSERT INTO CUSTOMER
VALUES(60, 'Adam', 'Sharif', NULL, '1830 North York', 'Ann Arbor', 'MI', 'United States', '48103', '+1 734 972 9491', NULL, 'asharif3003@gmail.com', 3);
INSERT INTO CUSTOMER
VALUES(61, 'Carlos', 'Rogers', NULL, '2342 Elden St', 'IN', 'South Bend', 'United States', '59323', '+1 834 384 9301', NULL, 'carlos123@gmail.com', 5);
/

--2.4
--Task – Update Aaron Mitchell in Customer table to Robert Walter 
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
/

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 
UPDATE ARTIST
SET NAME ='CCR'
WHERE NAME = 'Creedence Clearwater Revival';
/

--2.5
--Task – Select all invoices with a billing address like “T%” 
SELECT * 
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
/

--2.6
-- Task – Select all invoices that have a total between 15 and 50 
SELECT * 
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
/

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 
SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';
/

--2.7
--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). 
DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID FROM INVOICE 
                            WHERE CUSTOMERID IN(SELECT CUSTOMERID
                            FROM CUSTOMER
                            WHERE FIRSTNAME = 'Robert' and LASTNAME = 'Walter'));

DELETE FROM INVOICE 
WHERE CUSTOMERID = 32;

DELETE FROM CUSTOMER
WHERE FIRSTNAME ='Robert' AND LASTNAME ='Walter';
/


--3.1
--Create a function that returns the current time
create or replace function RetrieveCurrentTime
return varchar2
as
time1 varchar2(40);

    begin
    SELECT to_char(CURRENT_DATE, 'DD-MON-YYYY HH:MI:SS')
    into time1
    from dual;
    
    return time1;
end;
/
select RetrieveCurrentTime from dual;
/

-- Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function MediaTypeLength(mediatype_num Number)
return varchar
as length_media varchar(30);
length_number Number;
    begin 
    SELECT NAME INTO length_media -- select into will store the result into 
    --the variable
    FROM MEDIATYPE
    WHERE MEDIATYPEID = mediatype_num;
    
    length_number := length(length_media); -- calculating the length of the
    --variable using a built in function and assigning it to another variable
    return length_number;
end
;
/
select MediaTypeLength(4) from dual;
/

--3.2
--Task – Create a function that returns the average total of all invoices
create or replace function AvgInvoice
return NUMBER
as avgtotal NUMBER;
    begin
    SELECT AVG(i.TOTAL) INTO avgtotal FROM INVOICE i;
    return avgtotal;
end
;
/
select AvgInvoice from dual;
/

--Task – Create a function that returns the most expensive track
create or replace function ExpensiveTrack
return NUMBER
as mostexpensive NUMBER;
    begin
    SELECT MAX(m.UNITPRICE) INTO mostexpensive FROM TRACK m; 
    return mostexpensive;
end
;
/
select ExpensiveTrack from dual;
/

--3.3
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table 
create or replace function InvoiceLineAvg
return NUMBER
as invoiceavg NUMBER;
    begin 
    SELECT AVG(t.UNITPRICE) INTO iTotalAvg FROM INVOICELINE t;
    return invoiceavg;
end
;
/
select InvoiceLineAvg from dual;
/

--3.4
--Task – Create a function that returns all employees who are born after 1968.
create or replace function BornAfter

return SYS_REFCURSOR 
-- cursor has the result of query
AS 
    Cursor1 SYS_REFCURSOR;
begin
    
    OPEN Cursor1 FOR 
        SELECT e.FIRSTNAME || ' ' || e.LASTNAME || ' ' || e.TITLE || ' ' || e.ADDRESS || ' ' || e.CITY
        FROM EMPLOYEE e 
        WHERE e.BIRTHDATE > '31-Dec-68';
    
    return Cursor1;
end;
/
DECLARE
    employeeInfo SYS_REFCURSOR;
    
BEGIN
    employeeInfo := BornAfter;
    
    LOOP
        FETCH employeeInfo INTO employeeBorn;
        EXIT WHEN EmployeeInfo%NOTFOUND;
        DBMS_OUTPUT.put_line(employeeBorn);
    END LOOP;
    close EmployeeInfo;
end;
/


--4.1
-- Create a procedure which gets first and last names of all employees
create or replace procedure getEmployeeNames(procedure1 out sys_refcursor)
as
begin
    open procedure1 for select FIRSTNAME, LASTNAME from EMPLOYEE;
end;
/

-- Create a stored procedure that updates the personal information of an employee
create procedure employeeUpdate (emp_firstname varchar2, emp_lastname varchar2)
as
    begin
    update EMPLOYEE
    set ADDRESS = '123 Mondale Rd', CITY = 'Dearborn', STATE = 'MI'
    where LASTNAME = emp_firstname and FIRSTNAME = emp_lastname;

end;

exec employeeUpdate ('Margaret', 'Park');
/

--4.2
-- Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure EmployeeUpdate(emp_id Number, lastn varchar2, firstn varchar2, emp_title varchar2,
report Number, bdate Date, hdate Date, emp_address varchar2, emp_city varchar2, emp_state varchar2, 
emp_country varchar2, emp_postalcode varchar2, emp_phone varchar2, emp_fax varchar2, emp_email varchar2)
as
    begin
    UPDATE EMPLOYEE
    SET EMPLOYEEID = emp_id,
        LASTNAME = lastn,
        FIRSTNAME = firstn,
        TITLE = emp_title,
        REPORTSTO = report,
        BIRTHDATE = bdate,
        HIREDATE = hdate,
        ADDRESS = emp_address,
        CITY = emp_city,
        STATE = emp_state,
        COUNTRY = emp_country,
        POSTALCODE = emp_postalcode,
        PHONE = emp_phone,
        FAX = emp_fax,
        EMAIL = emp_email
    WHERE EMPLOYEEID = emp_id;
end
;
/
exec EmployeeUpdate(7, 'Randy','Smith','IT Staff',5,'24-Dec-87','04-Apr-16','123 Packard Rd', 'Herndon','VA', 'United States', '20171','703-323-2345', '+1 (703)323-4356', 'randy@chinookcorp.edu'); 
/

-- Create a stored procedure that returns the managers of an employee
create or replace procedure EmployeeStore(emp_name varchar2)
as
    begin
    select REPORTSTO
    from EMPLOYEE
    where FIRSTNAME = emp_name;
end;
/

exec EmployeeStore('Nancy');
/
--4.3
-- Create a stored procedure that returns the name and company of a customer
create or replace procedure customerDisplay(customer_id IN number, cursor1 OUT sys_refcursor)
as
begin
    open cursor1 for 
    select FIRSTNAME, LASTNAME, COMPANY
    from CUSTOMER
    where CUSTOMERID = customer_id;
end;
/


--5.0
-- Create a transaction that given a invoiceId will delete that invoice(There 
-- may be constraints that rely on this, find out how to resolve them)
create or replace procedure DeleteInvoice(invoice_id_number IN number)
as
    begin
  DELETE FROM INVOICE inv
  WHERE inv.INVOICEID = invoice_id_number;
  commit;
end;
/

begin
  DeleteInvoice(32);
end;
/

--Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure CustomerInsert(customer_id number,first_name 
varchar2,last_name varchar2,company varchar2, address varchar2,city varchar2,
state varchar2, country varchar2,postalcode varchar2,
phone varchar2,fax varchar2,email varchar2,supported_id number)
  as
begin
  INSERT INTO CUSTOMER
  VALUES (customer_id,first_name,last_name,company,address,city,state,country,postalcode,
  phone,fax,email,supported_id);
  commit;
end;
/


BEGIN
  CustomerInsert(65,'Bruce','Wayne','Wayne Enterprises','1007 Mountain Drive','Gotham City',
  'Gotham','USA','33333','832-423-3234','832-423-3211','officialbatman@gmail.com',4);
END;
/

--6.1
-- Create an after insert trigger on the employee table fired after a new 
-- record is inserted into the table
create or replace trigger EmployeeTrigger
  AFTER INSERT ON EMPLOYEE
begin
    dbms_output.put_line('A new record was inserted into the Employee table');
end;
/
-- Create an after update trigger on the album table that fires after a row is inserted in the table 
create or replace trigger AlbumTrigger
  AFTER UPDATE ON ALBUM
begin
    dbms_output.put_line('The album table is updated');
end;
/
-- Create an after delete trigger on the customer table that fires after a row is deleted from the table
create or replace trigger AlbumDeleteTrigger
  AFTER DELETE ON CUSTOMER
begin
    dbms_output.put_line('A row was deleted from the Customer table');
end;
/


--7.1
--Create an inner join that joins customers and orders and specifies the name 
--of the customer and the invoiceId
SELECT e.FIRSTNAME,e.LASTNAME,f.INVOICEID FROM CUSTOMER e
  INNER JOIN INVOICE f
  ON e.CUSTOMERID = f.CUSTOMERID;

--7.2
-- Create an outer join that joins the customer and invoice table, specifying 
--the CustomerId, firstname, lastname, invoiceId, and total
SELECT m.CUSTOMERID,m.FIRSTNAME,m.LASTNAME,n.INVOICEID,n.TOTAL FROM CUSTOMER m
  FULL OUTER JOIN INVOICE n
  ON m.CUSTOMERID = n.CUSTOMERID;
  
--7.3 
--Create a right join that joins album and artist specifying artist name and title
SELECT a.NAME,b.TITLE FROM ALBUM b
  RIGHT JOIN ARTIST a
  ON b.ARTISTID = a.ARTISTID;
  
--7.4
--Create a cross join that joins album and artist and sorts by artist name in 
--ascending order
SELECT c.NAME, d.TITLE FROM ALBUM d
  CROSS JOIN ARTIST c
  ORDER BY c.NAME ASC;

--7.5
--Perform a self-join on the employee table, joining on the reportsto column
  SELECT * FROM EMPLOYEE emp1, EMPLOYEE emp2
  WHERE emp1.REPORTSTO = emp2.REPORTSTO;
/
--7.6  
--Create an inner join between all tables in the chinook database
select *
FROM INVOICELINE 
inner join TRACK on INVOICELINE.TRACKID = TRACK.TRACKID
inner join GENRE on TRACK.GENREID = GENRE.GENREID
inner join ALBUM on TRACK.ALBUMID = ALBUM.ALBUMID
inner join PLAYLISTTRACK on PLAYLISTTRACK.TRACKID = TRACK.TRACKID
inner join INVOICE on INVOICELINE.INVOICEID = INVOICE.INVOICEID
inner join CUSTOMER on INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID
inner join EMPLOYEE on CUSTOMER.SUPPORTREPID = EMPLOYEE.REPORTSTO
inner join PLAYLIST on PLAYLIST.PLAYLISTID = PLAYLISTTRACK.PLAYLISTID
inner join MEDIATYPE on TRACK.MEDIATYPEID = MEDIATYPE.MEDIATYPEID
inner join ARTIST on ARTIST.ARTISTID = ALBUM.ARTISTID;

commit;