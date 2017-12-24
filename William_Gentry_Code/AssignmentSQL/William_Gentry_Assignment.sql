savepoint start_of_assignment;

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

savepoint after_insert_genres;
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

savepoint after_insert_employees;
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

savepoint after_insert_customers;

--2.4: UPDATE
--Task: Update Aaron Mitchell in Customer table to Robert Walter
update customer
    set FIRSTNAME = 'Robert', LASTNAME = 'Walter'
    where FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';
    
savepoint after_update_rm_to_aw;

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
savepoint rw_working;

--Not the most elegant solution, but with more than 5 hours attempting with nested queries for this problem, Ill take it    
delete from invoiceline where invoiceid = 50 
        or invoiceid = 61 or invoiceid = 245 
        or invoiceid = 268 or invoiceid = 116 
        or invoiceid = 342 or invoiceid = 290;
        
delete from invoice where CUSTOMERID = 32;

delete from customer where lastname = 'Walter';


--select count(*) from customer;

savepoint robert_walter_finally_deleted;
        

    

--3.0: SQL Functions
--3.1: System Defined Functions
--Task: Create a function that returns the current time
create or replace function retrieveCurrentTime
return TIMESTAMP as my_time TIMESTAMP;
BEGIN
    select CURRENT_TIMESTAMP into my_time from dual;
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




--4.0: Stored Procedures
--4.1: Basic Stored Procedures
--Task: Create a stored procedure that selects the first and last names of all the employees

create or replace procedure firstAndLastNamesOfEmployees (employeeNames out sys_refcursor)
as
begin
    open employeeNames for 
    select firstname, lastname from employee;
end;
/

--declare 
--  test sys_refcursor;
--  first   varchar2(20);
--  last   varchar2(20);
--begin
--  firstandlastnamesofemployees(test);
--
--  loop
--    fetch test into first, last;
--    exit when test%NOTFOUND;
--    dbms_output.put_line(first || ' ' || last);
--  end loop;
--  close test;
--end;
        


--4.2: Stored Procedure Input Parameter

--Task: Create a stored procedure that updates the personal information of an employee
--procedure will update employee based on employee id
--assumption is that employee cannot change firstname, lastname, birthday, or hire date
create or replace procedure updateEmployeePersonalInfo
(e_id in number, 
e_address in varchar2, 
e_city in varchar2, 
e_state in varchar2, 
e_country in varchar2, 
e_postalcode in varchar2, 
e_phone in varchar2, 
e_fax in varchar2,
e_email in varchar2)    
is
begin
    update employee
    set address = e_address,
    city = e_city,
    state = e_state,
    country = e_country,
    postalcode = e_postalcode,
    phone = e_phone,
    fax = e_fax,
    email = e_email,
    employeeid = e_id
    where employeeid = e_id;
end;
/


--Task: Create a stored procedure that returns the managers of an employee
--procedure will return manager based on employeeid
create or replace procedure thisEmployeesManager(e_id in number, e_manager out varchar2)
is
begin
    select concat(concat(e1.firstname, ' '), e1.lastname) as Manager into e_manager
    from EMPLOYEE e1
    inner join EMPLOYEE e2
    on e2.REPORTSTO = e1.EMPLOYEEID and e2.employeeid = e_id;
    
end;
/



--declare
--    emp_id number;
--    manager varchar2(30);
--begin
--    emp_id := 9;
--    thisemployeesmanager(emp_id, manager);
--    dbms_output.put_line(manager);
--end;
--/
    

--4.3: Output Parameters
--Task: Create a stored procedure that returns the name and company of a customer
create or replace procedure nameAndCompanyOfCustomer(c_id in Number, c_name out varchar2, c_company out varchar2)
is
begin
    select concat(concat(firstname, ' '), lastname) as Name into c_name from customer
    where customerid = c_id;
    select company as Company into c_company from customer
    where customerid = c_id;
end;
/

--declare
--    c_id number;
--    c_name varchar2(30);
--    c_company varchar2(30);
--begin
--    c_id := 60;
--    nameandcompanyofcustomer(c_id, c_name, c_company);
--    dbms_output.put_line(c_name || ' ' || c_company);
--end;
--/


--5.0: Transactions

--Task: Create a transaction that given an invoiceid will delete that invoice
create or replace procedure transactionToDeleteInvoice (invoiceNum in number)
as
begin
    delete from invoice where invoiceid = invoiceNum;
    delete from invoiceline where INVOICEID = invoiceNum;
    commit;
end;
/

--Task: Create a transaction nested within a stored procedure that inserts a new row in the customer table
create or replace procedure newCustomerInserted (
c_id in number,
c_fname in varchar2,
c_lname in varchar2,
c_company in varchar2,
c_address in varchar2,
c_city in varchar2,
c_state in varchar2,
c_country in varchar2,
c_postalcode in varchar2,
c_phone in varchar2,
c_fax in varchar2,
c_email in varchar2,
c_supportrepid in number
)
as
begin
    insert into customer values (c_id, c_fname, c_lname, c_company, c_address, c_city, c_state, c_country, c_postalcode,
                                c_phone, c_fax, c_email, c_supportrepid);
    commit;
end;
/


--6.0: Triggers
--6.1: After/For
--Task: Create an after insert trigger on the employees table which fires after a new record is inserted into the table
create table ptoeligibility (
employeeid number,
reportsto number,
firstname varchar2(20),
lastname varchar2(20),
ptomessage varchar(70)
);



create or replace trigger employeeptoeligibility 
after insert on employee for each row
begin
    if :NEW.reportsto <= 2 then 
        insert into ptoeligibility values (:NEW.employeeid, :NEW.reportsto, :NEW.firstname, :NEW.lastname, 'Eligible for PTO Accrual in 30 days');
    elsif :NEW.reportsto > 3 then
        insert into ptoeligibility values (:NEW.employeeid, :NEW.reportsto, :NEW.firstname, :NEW.lastname, 'Eligible for PTO Accrual in 180 days');
    end if;
end;
/


--Testing employeeptoeligibility trigger

--insert into employee values (11, 'test1', 'trigger', '', 2, '', '', '', '', '', '', '', '', '', '');
--insert into employee values (12, 'test1', 'trigger', '', 5, '', '', '', '', '', '', '', '', '', '');
--insert into employee values (13, 'test1', 'trigger', '', 1, '', '', '', '', '', '', '', '', '', '');
--
--select * from ptoeligibility;


--Task: Create an after update trigger on the album table that fires afters a row is updated in the table
create table albumupdatechanges (
message varchar(100),
updatetime timestamp
);


create or replace trigger changesInAlbumAfterUpdate
after update on album for each row
declare
    message varchar(100);
begin
    if :old.title <> :new.title then
        message := :old.title || ' changed to ' || :new.title || ' by ' || user;
    else 
        message := 'Artist Id was changed from  ' || :old.artistid || ' to ' || :new.artistid || ' by ' || user;
    end if;
    insert into albumupdatechanges values (message, sysdate);
end;
/


--Task: Create an after delete trigger on the customer table that fires after a row is deleted from the table
create table supportreptobenotified (
rep_first_name varchar2(20),
rep_last_name varchar2(20),
message varchar2(100)
);



create or replace trigger after_delete_customer
after delete on customer for each row
declare
    repfirstname varchar2(20);
    replastname varchar2(20);
    message varchar2(70);
begin
    select e.firstname into repfirstname from customer c 
    inner join employee e 
    on :old.supportrepid = e.employeeid
    where c.customerid = :old.customerid;

    select e.lastname into replastname from employee e 
    inner join customer c 
    on :old.supportrepid = e.employeeid
    where c.customerid = :old.customerid;
    
    message := 'Notify ' || repfirstname || ' ' || replastname || ' that ' || :old.firstname || ' ' || :old.lastname || ' is no longer their customer';

    insert into supportreptobenotified values (repfirstname, replastname, message);
end;
/



--7.0: Joins
--7.1: Inner Join
--Task: Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceid
select concat(concat(c.firstname, ' '), c.lastname) as Name, i.INVOICEID from customer c
    inner join invoice i 
    on c.customerid = i.customerid;


--7.2: Outer Join
--Task: Create an outer join that joins the customer table and invoice table, specifying the customer id,
--firstname, lastname, invoiceid, and total

select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total as Total from customer c 
    full outer join invoice i
    on c.customerid = i.customerid;
    
    
--7.3: Right Join
--Task: Create a right join that joins album and artist specifying artist name and album title
select ar.name as Artist, al.title as Album from artist ar
    right join album al
    on ar.artistid = al.artistid;


--7.4: Cross Join
--Task: Create a cross join that joins album and artist and sorts by artist name in ascending order
select ar.name as Artist, al.title as Album from artist ar
    cross join album al
    where ar.artistid = al.artistid
    order by ar.name asc;


--7.5: Self Join
--Task: Perform a self-join on the employee table, joining on the reportsto column
select concat(concat(e1.firstname, ' '), e1.lastname) as Employee, 
    concat(concat(e2.firstname, ' '), e2.lastname) as ReportsTo
    from employee e1
    inner join employee e2
    on e1.reportsto = e2.employeeid;
    



--7.6: Complicated Join Assignment
--Task: Create an inner join between all the tables in the chinook database

select concat(concat(e.firstname, ' '), e.lastname) as EMP_NAME, concat(concat(c.firstname, ' '), c.lastname) as C_NAME, i.invoiceid as INV_ID, 
    il.invoiceid as INVL_ID, tr.name as TR_NAME, al.title as Album, ar.name as Artist , g.name as Genre, mt.name as Mediatype, pl.name as Playlist
    
    from employee e
    inner join customer c
    on e.employeeid = c.supportrepid
    inner join invoice i
    on c.customerid = i.invoiceid
    inner join invoiceline il
    on i.invoiceid = il.invoiceid
    inner join track tr 
    on il.trackid = tr.trackid     
    inner join album al
    on al.albumid = tr.albumid
    inner join artist ar
    on ar.artistid = al.artistid
    inner join genre g
    on g.genreid = tr.genreid
    inner join mediatype mt
    on mt.mediatypeid = tr.mediatypeid
    inner join playlisttrack pt
    on tr.trackid = pt.trackid
    inner join playlist pl 
    on pl.playlistid = pt.playlistid
    ;
    


--9.0: Administration
--Task: Create a .bak file for the Chinook database

