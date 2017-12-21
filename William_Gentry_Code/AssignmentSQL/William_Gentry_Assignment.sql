--2.0: SQL Queries

--2.1: SELECT
--Task: Select all records from the Employee table
select * from employee;

--Task: Select all records from the Employee table where last name is King
select * from employee 
    WHERE LASTNAME = 'King';

--Task: Select all records from the Employee table where first name is Andrew and REPORTSTO is null
select * from employee 
    WHERE FIRSTNAME = 'Andrew' and REPORTSTO is null;


--2.2: ORDER BY
--Task: Select all albums in the Album table and sort the result set in descending order by title
select TITLE from album 
    ORDER BY title desc;

--Task: Select the first name from Customer table and sort the result set in ascending order by city
select firstname from customer 
    ORDER BY city;


--2.3: INSERT INTO 
--Task: Insert two new records into Genre Table
insert into genre (NAME, GENREID) values ('Screamo', 26);
insert into genre values (27, 'Trap');

--Task: Insert two new records into Employee Table
insert into employee values (
9, 
'Gentry', 
'William', 
'Junior Programmer',
6, 
to_date('1993-01-14', 'yy-mm-dd'),
to_date('2017-12-11', 'yy-mm-dd'),
'2310 Astoria Circle',
'Herndon',
'VA',
'United States',
'20172',
'+1 (404) 123-4567',
'+1 (444) 123-4567',
'william@chinookcorp.com'
);

insert into employee values (
10, 
'MySecond',
'InputStmt',
'Junior Sales Support Agent',
2,
to_date('1990-08-10', 'yy-mm-dd'),
to_date('2016-12-21', 'yy-mm-dd'),
'678 Test Drive SW',
'Reston',
'VA',
'United Stated',
'20172',
'+1 (703) 555-5585',
'+1 (773) 888-8858',
'testInputStmt@chinookcorp.com'
);

--Insert two new records into Customer table
insert into customer values (
60,
'William',
'Gentry',
'Revature',
'11730 Corporate America Drive',
'Reston',
'VA',
'United Stated',
'20170',
'+1 (404) 123-4567',
'+1 (444) 123-4567',
'william@assignment.com',
3
);

insert into customer values (
61,
'MySecond',
'InsertStmt',
'Mellow Mushroom',
'123 Peachtree PKWY N',
'Cumming',
'GA',
'United States',
'30024',
'+1 (770) 888-8858',
'',
'secondInsertStmt@assignment.com',
5
);


--2.4: UPDATE
--Task: Update Aaron Mitchell in Customer table to Robert Walter
update customer
    set FIRSTNAME = 'Robert', LASTNAME = 'Walter'
    where FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';

--Task: Update name of artist in Artist table from "Creedence Clearwater Revival" to "CCR"
update artist
    set NAME = 'CCR'
    where NAME = 'Creedence Clearwater Revival';

--2.5: Like
--Task: Select all invoices with a billing address like "T%"
select * from invoice 
    where BILLINGADDRESS like 'T%';       


--2.6: Between
--Task: Select all invoices that have a total between 15 and 50
select * from invoice 
    where TOTAL between 15 and 50;    --'between' is inclusive, will return a <= b

--Task: Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee 
    where HIREDATE between to_date('2003-03-01', 'yy-mm-dd') and to_date('2004-03-01', 'yy-dd-mm');
    
    
--2.7 Delete
--Task: Delete a record in the Customer table where the name is Robert Walter
desc customer;
alter table invoice
    drop constraint FK_INVOICECUSTOMERID;

alter table invoice
    add constraint FK_INVOICECUSTOMERID_CASCADE
    foreign key (CUSTOMERID)
    references customer (CUSTOMERID)
    on delete cascade;

alter table invoiceline
    drop constraint FK_INVOICELINEINVOICEID;
    
alter table invoiceline
    add constraint FK_INVOICELINEINVOICEID
    foreign key (INVOICEID)
    references invoice (INVOICEID)
    on delete cascade;


delete from customer where FIRSTNAME = 'Robert' and LASTNAME = 'Walter';



--3.0: SQL Functions
--3.1: System Defined Functions
--Task: Create a function that returns the current time
create or replace function retrieveCurrentTime
return TIMESTAMP as my_time TIMESTAMP;
BEGIN
    my_time := CURRENT_TIMESTAMP;
    return my_time;
END
;
/

--Task: Create a function that returns the length of a mediatype from the mediatype table
create or replace function lengthOfMedia (id Number)
return number
as mediaLength number(20);
nameOfMedia varchar(50);
begin
    select name into nameOfMedia from mediatype where MEDIATYPEID = id;
    mediaLength := length(nameOfMedia);
    return mediaLength;
end
;
/


--3.2: System defined aggregate functions
--Task: Create a function that returns the average total of all invoices
create or replace function averageOfInvoiceTotal
return number
as averageInvoiceTotal Number(10, 2);
begin
    select avg(total) into averageInvoiceTotal from invoice;
    return averageInvoiceTotal;
end
;
/

--Task: Create a function that returns the most expensive track
create or replace function mostExpensiveTrack
return number
as mostExpensive number(10,2);
begin
    select max(UNITPRICE) into mostExpensive from track;
    return mostExpensive;
end
;
/


--3.3: User Defined Functions
--Task: Create a function that returns the average price of invoiceline items from invoiceline table
create or replace function averageInvoicelinePrice
return Number
as avgPrice Number (10,2);
begin
    select avg(unitprice) into avgPrice from invoiceline;
    return avgPrice;
end;
/


--3.4: User Defined Table Valued Functions
--Task: Create a function that returns all employees born after 1968
create or replace function employeesBornAfter1968
return sys_refcursor
as bornAfter1968 sys_refcursor;
begin
    open bornAfter1968  
        for select employeeid, lastname, firstname, title, reportsto, birthdate, hiredate,
        address, city, state, country, postalcode, phone, fax, email from employee 
        where (birthdate > to_date('1968-12-31', 'yyyy-mm-dd')); 
    return bornAfter1968;
end
;
/



