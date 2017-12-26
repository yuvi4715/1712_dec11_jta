-- Section 2.0 SQL Queries

-- Section 2.1 SELECT

-- Select all records from Employee table
Select *
from employee;

-- Select all records from Employee table which contain the last name 'King'
-- I used the where clause to get only the emloyees with the last name 'King'
Select * 
from employee
where lastname = 'King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO IS NULL.
-- I used the where clause to select only the employees with the first name 'Andrew'
select *
from employee
where firstname = 'Andrew'
and reportsto is null;

-- Section 2.2 ORDER BY

-- Select all albums in Album table and sort result set in descending order by title.
-- I used order by to sort the  titles in descending order
Select *
from album
order by title desc;


-- Select first name from Customer and sort result set in ascending order by city
-- I used order by to sort the cities in ascending order
Select firstname
from customer
order by city asc;


-- Section 2.3 INSERT INTO

-- Insert two new records into Genre table
-- genre table only has 2 attributes; genreid = 26, name = 'EDM'
insert into genre values(26, 'EDM');
insert into genre values(27, 'Techno');


-- Insert two new records into Employee table
-- employee table has 15 attributes
insert into employee values(9, 'Ashraf', 'Aisha', 'Vice President', '', '15-MAY-78', '20-DEC-17', '2386 115th Ave SE', 'Calgary', 'AB', 'Canada', 'T2P 5D9', '1 (403) 423-0812', '1 (403) 437-0118', 'aisha@chinookcorm.com');
insert into employee values(10, 'Danso', 'Jeff', 'Janitor', '', '7-MAR-84', '12-SEP-17', '2710 145th Ave NW', 'Calgary', 'AB', 'Canada', 'T2P 5K6', '1 (403) 411-9912', '1 (403) 437-4982', 'jeff@chinookcorm.com');


-- Insert two new records into Customer table
-- customer table has 13 attributes
insert into customer values(60, 'Jason', 'Shen', 'Microsoft Corporation', '1 Microsoft Way', 'Redmond', 'WA', 'USA', '98052-8300', '1 (425) 425-4254', '1 (425) 425-4255', 'jshen@microsoft.com', '5');
insert into customer values(61, 'Tom', 'Brady', 'New England Patriots', '1 Patriot Pl.', 'Foxborough', 'MA', 'USA', '02035', '1 (508) 543-8200', '1 (508) 543-8201', 'tb12@patriots.com', '2');


-- Section 2.4 UPDATE

--Update Aaron Mitchell in Customer table to Robert Walter
update customer
set firstname = 'Robert', lastname = 'Walker'
where firstname = 'Aaron'
and
lastname = 'Mitchell';


-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';


-- Section 2.5 LIKE

-- Select all invoices with a billing address like “T%”
-- this will select only the records with a billing address that starts with the letter t
select *
from invoice
where billingaddress 
like 'T%';


-- Section 2.6 BETWEEN

-- Select all invoices that have a total between 15 and 50
select *
from invoice
where total
between 15 and 150;


-- Select all employees hired between 1st of June 2003 and 1st of March 2004
select * 
from employee
where HIREDATE
between '1-JUN-03' and '1-MAR-04';


-- Section 2.7 DELETE

-- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
-- I was not able to delete Robert Walker from the customer table right away, because the invoice table contained records which had his customerid. 
-- and the invoiceline table contained records which used his customerid as well, through it's relationship with the invoice table
-- in order to solve the problem, I first had to delete the records from invoiceline table which had Robert Walkers customerid. Then I had to delete the records
-- from invoice table which used his customerid. Finally I was able to delete Robert Walker from the customer table
delete (select *
from invoiceline
inner join invoice 
on invoice.invoiceid = invoiceline.invoiceid
where invoice.customerid = 32);

delete
from invoice
where customerid = 32;

DELETE
from customer
where firstname = 'Robert'
and
lastname = 'Walker';


-- Section 3.0 SQL Functions

-- Section 3.1 System defined Functions

-- Create a function that returns the current time.
-- created a function named 'getCurrentTume'
-- the function returns varchar data type as currenttime
-- used to_char to convert the timestamp into a char so it can be returned
create or replace function getCurrentTime
return varchar
as currentTime varchar(25);
begin
    SELECT to_char(LOCALTIMESTAMP, 'HH:MI:SS')
    INTO currentTime from dual;
    return currentTime;
end
;
/
 -- this statement executes the function I just created
select getCurrentTime from dual;


-- create a function that returns the length of a mediatype from the mediatype table
-- created a function named 'getMediatypeLength'
-- the function returns a number data type as lengthOfMedia
create or replace function getMediatypeLength(mediaNum number)
return number
as lengthOfMedia number;
mediaName varchar(30);
begin
    SELECT m.NAME into mediaName from Mediatype m
    where m.mediatypeid = mediaNum;
    lengthOfMedia := length(mediaName);
    return lengthOfMedia;
end
;
/

 -- this statement executes the function I just created
select getMediaTypeLength(2) from dual;


-- Section 3.2 System Defined Aggregate Functions

-- Create a function that returns the average total of all invoices
-- created a function that returns the average of all invoices in the invoice table
-- returns the number data type as avgTotal
create or replace function avgTotalInvoices
return number
as avgTotal number;
begin
    select avg(total) as avgTotal
    into avgTotal
    from invoice;
    return avgTotal;
end
;
/

 -- this statement executes the function I just created
select avgTotalInvoices from dual;


-- Create a function that returns the most expensive track

-- created a function that returns the most expensive track from the track table
-- returns the number data type as mostExpensive
create or replace function mostExpensiveTrack  
return number
as mostExpensive number;
begin
    select max(unitprice) into mostExpensive
    from track;
    return mostExpensive;
end
;
/

 -- this statement executes the function I just created
select mostExpensiveTrack from dual;


-- Section 3.3 User Defined Functions

-- Create a function that returns the average price of invoiceline items in the invoiceline table
-- created a function that returns the average price of items in the invoiceline table
-- returns the number data type as avgP
create or replace function avgPrice
return number
as avgP number;
begin
    select avg(unitprice) into avgP
    from invoiceline;
    return avgP;
end
;
/

 -- this statement executes the function I just created
select avgPrice from dual;


-- Section 3.4 User Defined Table Valued Functions

-- Create a function that returns all employees who are born after 1968.
-- created a function named 'bornPost68' which returns a cursor named 'employee_cursor'
-- first I opened the cursor and fed the information into it
-- then returned the cursor which is now holding the information it was given
create or replace function bornPost68 return sys_refcursor

is

employee_cursor sys_refcursor;  

begin
  open employee_cursor for select * from employee where birthdate >  to_date(1968, 'YYYY');
  
  return employee_cursor;
end
;
/

 -- this statement executes the function I just created
select bornPost68 from dual;



-- Section 4.0 Stored Procedures

-- Section 4.1 Basic Stored Procedure

-- Create a stored procedure that selects the first and last names of all the employees.
-- created a procedure named 'emp_names' which takes a cursor 'emp_cursor' as a parameter
-- first I opened the cursor, thenfed it the information (first and last names)
-- then I declared the cursor and 2 varchar variables to hod the first and last names
-- then I created a loop which runs until there is no information left
create or replace procedure emp_names(emp_cursor out sys_refcursor)
as
begin
    open emp_cursor for select firstname, lastname from employee;
end
;
/

declare
    emp_cursor sys_refcursor;
    fName varchar2(30);
    lName varchar2(30);
begin
    emp_names(emp_cursor);
    loop
        fetch emp_cursor into fName, lName;
        exit when emp_cursor%notfound;
        dbms_output.put_line(upper(lName)|| ',' || upper(fName));
    end loop;
end;
/


-- Section 4.2 Stored Procedure Input Parameters

-- Create a stored procedure that updates the personal information of an employee.
-- created a proedure called 'updateEmployee' which takes 3 parameters
-- the procedure updates the employee first and last names of the employee with the given id number
create or replace procedure updateEmployee(
	   emp_firstname in employee.firstname%TYPE,
	   emp_lastname in employee.lastname%TYPE, 
       emp_employeeid in employee.employeeid%TYPE)
is
begin

  update employee set firstname = emp_firstname, lastname = emp_lastname where  employeeid= emp_employeeid;


end;
/

 -- this statement block executes the procedure that I just created
begin
   updateEmployee('Tom', 'Brady', 2);
end;


-- Create a stored procedure that returns the managers of an employee.
-- created a stored procedure called 'getEmpManager' 
-- this procedure retrieves and returns the first and last name of an employees manager as manager_name
-- returns the name of the manager of the employee who's id is entered into the parameters whem the procedure is executed
create or replace procedure getEmpManager(eid number)
as 
manager_name varchar2(50);
begin
-- concat the first and last name to pass them into one variable
select concat(concat(firstname, ' '),lastname) as name into manager_name from employee where employeeid = (select reportsto from employee where employeeid = eid);
dbms_output.put_line(manager_name);

end getEmpManager;
/
-- turning the server on so my procedure can give the correct output
set serveroutput on;
 -- this statement executes the procedure that I just created
exec getEmpManager(3);

-- Section 4.3 Stored Procedure Output Parameters

-- Create a stored procedure that returns the name and company of a customer.
-- created a procedure called 'nameAndCompany'
-- retrieves and prints the full name and the company name for the given customer
create or replace procedure nameAndCompany (cid number)
as
custName varchar2(50);
companyName varchar2(50);
begin
-- concat the first and last name to pass them into one variable
select concat(concat(firstname, ' '),lastname), company as name into custName, companyName from customer where customerid = (select customerid from customer where customerid = cid);
dbms_output.put_line(custName);
dbms_output.put_line(companyName);

end nameAndCompany;
/

-- turning the server on so my procedure can give the correct output
set serveroutput on;
 -- this statement executes the procedure that I just created
exec nameAndCompany(15);


-- Section 5.0 Transactions

-- – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
-- rely on this, find out how to resolve them).
-- created a procedure called 'deleteInv' which takes an invoice number as a parameter
-- the procedure will delete any records associated with the passed in invoice number
-- from the invoive and invoiceline tables
create or replace procedure deleteInv (inv Number)
as
begin
    delete from invoiceline where INVOICEID = inv;
    delete from invoice where invoiceid = inv;
    commit; -- this is a transaction statement that makes the changes that we just made, PERMANENT
end;
/
 -- this statement executes the procedure that I just created
exec deleteInv(12);


-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
-- created a procedure called 'newCustomer' which has no parameters
-- this procedure will create a new customer and enter him/her into the customer table
create or replace procedure newCustomer
as
begin
    insert into customer values (62, 'Kyrie', 'Irving', 'Boston Celtics', '100 Causeway st.', 'Boston', 'MA', 'USA', '01660', '1 (617) 779-0985', '1(617) 779-0986', 'kyrieswerving@Celtics.com', 3 );
    commit; -- this is a transaction statement that makes the changes that we just made, PERMANENT
end;
/
 -- this statement executes the procedure that I just created
exec newCustomer;



-- Section 6.0 Triggers

-- Section 6.1 After/For

-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger insert_employee
after insert on employee for each row
begin
    dbms_output.put_line('insert employee trigger');
end;
/

-- Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger insert_album
after insert on album for each row
begin
    dbms_output.put_line('insert album trigger');
end;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger delete_customer
after delete on customer for each row
begin
    dbms_output.put_line('delete customer trigger');
end;
/



-- Section 7.0 Joins

-- Section 7.1 Inner join

-- Create an inner join that joins customers and orders and specifies the name of the customer and
-- the invoiceId.
-- joined the tables on matching customerid fields and concatenated the first and last name into one name field
select concat(concat(customer.firstname, ' '), customer.lastname) as name, invoice.invoiceid
from customer
inner join invoice
on customer.customerid = invoice.customerid;

-- Section 7.2 Outer join

-- Create an outer join that joins the customer and invoice table, specifying the CustomerId,
-- firstname, lastname, invoiceId, and total.
-- joined the tables on matching customerid fields 
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer
full outer join invoice
on customer.customerid = invoice.customerid;

-- Section 7.3 Right join

-- Create a right join that joins album and artist specifying artist name and title.
-- joined the tables on matching artistid fields
select artist.name, album.title
from album
right outer join artist
on album.artistid = artist.artistid;

-- Section 7.4 Cross join

-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
-- joined the tables and ordered by artist name in ascending order
select *
from album
cross join artist
order by artist.name asc;

-- Section 7.5 Self join

-- Perform a self-join on the employee table, joining on the reportsto column.
-- joined the tables on matching reportsto fields
select * 
from employee
self join employee
on employee.reportsto = self.reportsto;

-- Section 7.6 Complicated join assignment

-- Create an inner join between all tables in the chinook database.
select *
from employee
inner join customer
    on customer.supportrepid = employee.employeeid -- joined employee and customer using supportrepid and employeeid fields
inner join invoice
    on invoice.customerid = customer.customerid -- joined invoice and customer using matching customerid fields
inner join invoiceline
    on invoiceline.invoiceid = invoice.invoiceid -- joined invoice and invoiceline using matching invoiceid fields
inner join track
    on track.trackid = invoiceline.trackid -- joined track and invoiceline using matching trackid fields
inner join genre
    on genre.genreid = track.genreid -- joined genre and track using matching genreid fields
inner join mediatype
    on mediatype.mediatypeid = track.mediatypeid -- joined track and mediatype using matching medietypeid fields
inner join album
    on album.albumid = track.albumid -- joined album and track using matching albumid fields
inner join artist
    on artist.artistid = album.artistid -- joined artist and album using matching artistid fields
inner join playlisttrack
    on playlisttrack.trackid = track.trackid -- joined track and playlisttrack using matching trackid fields
inner join playlist
    on playlist.playlistid = playlisttrack.playlistid; -- joined playlist and playlisttrack using matching playlistid fields
    
-- I was not able to create a .bak file for the database.     